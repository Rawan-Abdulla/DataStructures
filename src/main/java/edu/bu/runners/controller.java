package edu.bu.runners;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class controller {
	@GetMapping("/somepath5")
	public String c5(@RequestParam Double lat, @RequestParam Double lon) {
		System.out.println(lat);
		return "{\"type\": \"Point\", \"coordinates\" : [" + lon + "," + lat + "]}";

	}
}