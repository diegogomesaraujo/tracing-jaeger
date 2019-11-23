package com.github.diegogomesaraujo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.diegogomesaraujo.dto.Address;
import com.github.diegogomesaraujo.feign.client.ViaCepRestClient;

@RestController
@RequestMapping("/addresses")
public class AddressController {

	@Autowired
	private ViaCepRestClient viaCepRestClient;
	
	@GetMapping("/{cep}")
	public Address find(@PathVariable String cep) {
		return viaCepRestClient.findAddress(cep);
	}
	
}
