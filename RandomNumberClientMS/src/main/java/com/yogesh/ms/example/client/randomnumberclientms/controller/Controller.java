package com.yogesh.ms.example.client.randomnumberclientms.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {

	@GetMapping("/restclient/from/{from}/to/{to}")
	public ResponseEntity<ArrayList> RestClient (@PathVariable String from, @PathVariable String to)
	{
		Map<String, String> uriVariables = new HashMap<>();
	    uriVariables.put("from", from);
	    uriVariables.put("to", to);
	    
		ResponseEntity<ArrayList> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/randomnumber/from/{from}/to/{to}", ArrayList.class, uriVariables);
		
		return responseEntity;
	}
}
