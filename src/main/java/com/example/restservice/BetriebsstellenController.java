package com.example.restservice;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BetriebsstellenController {
	private final Betriebsstellen betriebsstellen;
	private String[] relevant_columns = {"Name", "Kurzname", "Typ"};
	
	public BetriebsstellenController(Betriebsstellen betriebsstellen) {
		this.betriebsstellen = betriebsstellen;
	}
	
	@GetMapping("/betriebsstelle/{id}")
	@ResponseBody
	public Map<String,String> betriebsstelle(@PathVariable String id) {
		String[] betriebsstelle = betriebsstellen.findBetriebsstelleBy("Abk",id);
		return betriebsstellen.printToMap(betriebsstelle,relevant_columns);
	}
}