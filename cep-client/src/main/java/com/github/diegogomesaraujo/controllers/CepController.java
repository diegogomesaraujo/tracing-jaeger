package com.github.diegogomesaraujo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.github.diegogomesaraujo.dto.Address;
import com.github.diegogomesaraujo.exceptions.AddressNotFoundException;

@RestController
@RequestMapping("/cep")
public class CepController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/{cep}")
	public Address find(@PathVariable String cep) {
		var url = String.format("http://localhost:8080/addresses/%s", cep);
		
		var response = restTemplate.getForEntity(url, Address.class);
		
		if(!HttpStatus.OK.equals(response.getStatusCode())) {
			throw new AddressNotFoundException("Address not found");
		}
		
		return response.getBody();
	}
	
}
