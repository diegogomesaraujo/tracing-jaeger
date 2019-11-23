package com.github.diegogomesaraujo.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.github.diegogomesaraujo.dto.Address;

@FeignClient(name = "viaCepRestClient", url = "https://viacep.com.br", path = "/ws")
public interface ViaCepRestClient {

	@GetMapping("/{cep}/json")
	public Address findAddress(@PathVariable String cep);
	
}
