package com.atpex.apoptosis.viewresolver;

import java.util.Locale;
import java.util.Map;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

public class MultiViewResolver implements ViewResolver{

	private Map<String, ViewResolver> resolvers;

	private final static String DEFAULT_RESOLVER = "jsp";
	private final static String JSON_RESOLVER = "json";
	private final static String JSON_VIEW_NAME = "jsonView";

	@Override
	public View resolveViewName(String viewName, Locale locale)
			throws Exception {

		// �ж��Ƿ�Ϊjson
		String tmpViewName = viewName.trim().toLowerCase();
		if (JSON_RESOLVER.equals(tmpViewName)) {
			ViewResolver resolver = resolvers.get(JSON_RESOLVER);
			return resolver.resolveViewName(JSON_VIEW_NAME, locale);
		}
		// �����»��ߣ�Ĭ��ת��jsp��ͼ
		int n = viewName.lastIndexOf("_");
		if (n == (-1)) {
			ViewResolver resolver = resolvers.get(DEFAULT_RESOLVER);
			return resolver.resolveViewName(viewName, locale);
		}
		// �еĻ���ȡ�»��ߺ�����ַ��� ����һ����jsp,ftl,vm�������ļ��е�<entry key="ftl">��keyƥ��
		String suffix = viewName.substring(n + 1);
		// �����»��ߺ�����ַ���ȥ��ȡ�йܵ���ͼ���������
		ViewResolver resolver = resolvers.get(suffix);
		// ȡ�»���ǰ��Ĳ��� ��ʱ��������Դ��.��������Ҫʹ��hello.jsp ��viewName��Ӧ����hello_jsp
		viewName = viewName.substring(0, n);
		if (resolver != null) {
			return resolver.resolveViewName(viewName, locale);
		}
		return null;
	}
	
    public Map<String, ViewResolver> getResolvers() {
        return resolvers;
    }
 
    public void setResolvers(Map<String, ViewResolver> resolvers) {
        this.resolvers = resolvers;
    }

}
