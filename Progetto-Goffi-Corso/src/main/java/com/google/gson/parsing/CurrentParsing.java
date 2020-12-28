package com.google.gson.parsing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class CurrentParsing {
	
	
/**
 * conversione da file json a Map : key-->value 
 * 
 * 
 * @param str --> sringa che contiene il json preso dalla chiamata API
 * 
 * @return map 
 * 
 * */
	public static Map<String, Object> jsonToMap(String str) {
		Map<String, Object> map = new Gson().fromJson(str, new TypeToken<HashMap<String, Object>>() {}.getType());
		return map;
	}	
	}

