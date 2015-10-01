package com.atpex.apoptosis.utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

public class CommonParam {

	public static void setAccessTime(ModelAndView model) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		model.addObject("ACT_TIME", sdf.format(new Date()));
	}
	
	public static void setGlobalMsg(ModelAndView model) {
		model.addObject("MESSAGE", Constants.GLOBAL_MESSAGE);
	}

	/**
	 * ��һ�� Map ����ת��Ϊһ�� JavaBean
	 * 
	 * @param type
	 *            Ҫת��������
	 * @param map
	 *            ��������ֵ�� map
	 * @return ת�������� JavaBean ����
	 * @throws IntrospectionException
	 *             �������������ʧ��
	 * @throws IllegalAccessException
	 *             ���ʵ���� JavaBean ʧ��
	 * @throws InstantiationException
	 *             ���ʵ���� JavaBean ʧ��
	 * @throws InvocationTargetException
	 *             ����������Ե� setter ����ʧ��
	 */
	@SuppressWarnings("rawtypes")
	public static Object convertMap(Class type, Map map) {

		BeanInfo beanInfo; // ��ȡ������
		Object obj = null; // ���� JavaBean ����
		try {
			beanInfo = Introspector.getBeanInfo(type); // ��ȡ������
			obj = type.newInstance(); // ���� JavaBean ����
			// �� JavaBean ��������Ը�ֵ
			PropertyDescriptor[] propertyDescriptors = beanInfo
					.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName();

				if (map.containsKey(propertyName)) {
					// ����һ����� try ������������һ�����Ը�ֵʧ�ܵ�ʱ��Ͳ���Ӱ���������Ը�ֵ��
					Object value = map.get(propertyName);

					Object[] args = new Object[1];
					args[0] = value;

					descriptor.getWriteMethod().invoke(obj, args);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	/**
	 * ��һ�� JavaBean ����ת��Ϊһ�� Map
	 * 
	 * @param bean
	 *            Ҫת����JavaBean ����
	 * @return ת�������� Map ����
	 * @throws IntrospectionException
	 *             �������������ʧ��
	 * @throws IllegalAccessException
	 *             ���ʵ���� JavaBean ʧ��
	 * @throws InvocationTargetException
	 *             ����������Ե� setter ����ʧ��
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map convertBean(Object bean) {
		Class type = bean.getClass();
		Map returnMap = new HashMap();
		BeanInfo beanInfo;
		try {
			beanInfo = Introspector.getBeanInfo(type);
			PropertyDescriptor[] propertyDescriptors = beanInfo
					.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName();
				if (!propertyName.equals("class")) {
					Method readMethod = descriptor.getReadMethod();
					Object result = readMethod.invoke(bean, new Object[0]);
					if (result != null) {
						returnMap.put(propertyName, result);
					} else {
						returnMap.put(propertyName, "");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnMap;
	}
}
