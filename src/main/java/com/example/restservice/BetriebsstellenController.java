package com.example.restservice;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BetriebsstellenController {
	private final Betriebsstellen betriebsstellen;
	private String[] relevant_columns = {"Name", "Kurzname", "Typ"};
	
	public BetriebsstellenController(Betriebsstellen betriebsstellen) {
		this.betriebsstellen = betriebsstellen;
	}
	
	@GetMapping("/betriebsstelle")
	public Map<String,String> betriebsstelle(
			@RequestParam(value = "Abk", defaultValue = "") String identifier
			) {
		String[] betriebsstelle = betriebsstellen.findBetriebsstelleBy("Abk",identifier);
		return betriebsstellen.printToMap(betriebsstelle,relevant_columns);
	}
}