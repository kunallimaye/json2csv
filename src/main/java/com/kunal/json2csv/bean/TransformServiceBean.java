/**
 * 
 */
package com.kunal.json2csv.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.inject.Inject;

import org.json.JSONObject;
import org.json.XML;

import com.kunal.json2csv.TransformService;

/**
 * @author kunallimaye
 *
 */

public class TransformServiceBean implements TransformService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6915910038484938302L;
	
	@Inject
	Logger logger;
	
	Map<String, List<String>> resultMap = new HashMap<String, List<String>>();
	
	public String convert(String stringToConvert){
		String result = "";
		logger.info("\n\n" + stringToConvert + "\n\n");
		if(stringToConvert != null){
			JSONObject jsonObject = new JSONObject(stringToConvert);
			String xmlString = XML.toString(jsonObject, "test");
			logger.info(xmlString);
		}
		return result;
	}
	
}
