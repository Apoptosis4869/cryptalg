package com.atpex.apoptosis.views;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.view.AbstractView;

import com.google.gson.Gson;

public class JsonView extends AbstractView {

	public static final String DEFAULT_CONTENT_TYPE = "application/json";
	
	public static final String HTML_CONTENT_TYPE = "text/html";
	
	public static final String DEFAULT_CHAR_ENCODING = "UTF-8";
	
	private String encoding = DEFAULT_CHAR_ENCODING;
	
	private Object jsonData = null;
	
	private Map<String,Object> _jsonDataMap = new HashMap<String,Object>();

	private Set<String> renderedAttributes;
	
	public void setEncoding(String encoding){
		this.encoding = encoding;
	}
	
	public JsonView(){
		setContentType(DEFAULT_CONTENT_TYPE);
	}
	
	public JsonView(Object object){
		setContentType(DEFAULT_CONTENT_TYPE);
		this.jsonData = object;
	}
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setCharacterEncoding(encoding);
		response.setContentType(getContentType());
		
		PrintWriter out = response.getWriter();
		
		if(jsonData != null){
			out.print(new Gson().toJson(jsonData));
		}else if(!_jsonDataMap.isEmpty()){
			out.print(new Gson().toJson(_jsonDataMap));
		}else {
			model = parseModel(model);
			out.print(new Gson().toJson(model));
		}
	}
	
	
	protected Map<String, Object> parseModel(Map<String, Object> model) {
		Map<String, Object> result = new HashMap<String, Object>();
		Set<String> renderedAttributes = !CollectionUtils
				.isEmpty(this.renderedAttributes) ? this.renderedAttributes
				: model.keySet();
		for (Map.Entry<String, Object> entry : model.entrySet()) {
			if (!(entry.getValue() instanceof BindingResult)
					&& renderedAttributes.contains(entry.getKey())) {
				result.put(entry.getKey(), entry.getValue());
			}
		}
		return result;

	}
	
	public void setJsonData(Object jsonData) {
		this.jsonData = jsonData;
	}

	public static JsonView returnJson(Object jsonData) {
		JsonView jsonView = new JsonView();
		jsonView.setJsonData(jsonData);
		return jsonView;
	}

	public JsonView put(String key, Object value) {
		_jsonDataMap.put(key, value);
		return this;
	}

}
