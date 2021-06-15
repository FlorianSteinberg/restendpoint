package com.example.restservice;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class CSVParse {
	public static BufferedReader reader() throws Exception {
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream inputStream = classloader.getResourceAsStream("Betriebsstellenverzeichnis.csv");
		InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
		return new BufferedReader(streamReader);
	}
	
	public static CSVParser parser() throws Exception {
		return new CSVParserBuilder().withSeparator(";".charAt(0)).build();
	}
	
	public static String[] spaltennamen() throws Exception {
		CSVReader csvReader = new CSVReaderBuilder(reader())
				.withCSVParser(parser())
				.build();
		String[] spaltennamen = csvReader.readNext();
		return spaltennamen;
	}
	
	public static List<String[]> betriebsstellen() throws Exception {
		CSVReader csvReader = new CSVReaderBuilder(reader())
				.withCSVParser(parser())
				.withSkipLines(1)
				.build();
		
		List<String[]> betriebsstellen = csvReader.readAll();
		return betriebsstellen;
	}
}