package com.devsuperior.dsmeta.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import com.devsuperior.dsmeta.services.SaleService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping (value = "/sales" )
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	@GetMapping
	public Page<Sale> findSales(
			@RequestParam (value="minDate", defaultValue="") String minDate, 
			@RequestParam (value="maxDate", defaultValue="") String maxDate, 
			Pageable pageable) {
		
		return service.findSales(minDate, maxDate, pageable);
		
	}	

}