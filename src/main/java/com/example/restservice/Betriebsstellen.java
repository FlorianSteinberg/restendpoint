package com.example.restservice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Betriebsstellen {
	private String[] spaltennamen;
	private List<String[]> betriebsstellen;
	
	public Betriebsstellen () {
		try {
			this.spaltennamen = CSVParse.spaltennamen();
		} catch (Exception e) {
			e.printStackTrace();
		};
		try {
			betriebsstellen = CSVParse.betriebsstellen();
		} catch (Exception e) {
			e.printStackTrace();
		};
	}
	
	public String[] findBetriebsstelleBy (String column_name, String value) {
		int column_index = Arrays.asList(spaltennamen).indexOf(column_name);
		return betriebsstellen.stream()
				.filter(details -> details[column_index].equalsIgnoreCase(value))
				.findFirst()
				.orElse(null);
	}
	
	public Map<String,String> printToMap (String[] betriebsstelle, String[] relevant_columns) {
		Map<String,String> betriebsstelleMap = new HashMap<>();
		for (int i = 0; i < relevant_columns.length; i++) {
			if (!betriebsstelle[i].equals("")) {
				int column_index = Arrays.asList(spaltennamen).indexOf(relevant_columns[i]);
				betriebsstelleMap.put(spaltennamen[column_index],betriebsstelle[column_index]);
				}
		}	
		return betriebsstelleMap;
	}
}