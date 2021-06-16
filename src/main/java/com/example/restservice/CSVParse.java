package com.example.restservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.core.io.ClassPathResource;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class CSVParse {
	public static BufferedReader reader() throws Exception {
		InputStream inputStream = new ClassPathResource("Betriebsstellenverzeichnis.csv").getInputStream();
		InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
		return new BufferedReader(streamReader);
	}
	
	public static CSVParser parser() throws Exception {
		return new CSVParserBuilder().withSeparator(';').build();
	}
	
	public static String[] spaltennamen() throws Exception {
		CSVReader csvReader = new CSVReaderBuilder(reader())
				.withCSVParser(parser())
				.build();
		try {
			return csvReader.readNext();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static List<String[]> betriebsstellen() throws Exception {
		CSVReader csvReader = new CSVReaderBuilder(reader())
				.withCSVParser(parser())
				.withSkipLines(1)
				.build();
		
		try {
			return csvReader.readAll();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}