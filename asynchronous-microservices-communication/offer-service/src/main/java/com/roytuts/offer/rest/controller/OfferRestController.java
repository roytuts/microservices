package com.roytuts.offer.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.roytuts.offer.dto.OfferDto;
import com.roytuts.offer.service.OfferService;

@RestController
public class OfferRestController {

	@Autowired
	private OfferService offerService;

	@PostMapping("/offer/create")
	public ResponseEntity<OfferDto> createOffer(@RequestBody OfferDto offerDto) {

		OfferDto saved = offerService.saveOffer(offerDto);

		if (saved != null) {
			return new ResponseEntity<OfferDto>(saved, HttpStatus.CREATED);
		}

		throw new RuntimeException("Error during saving offer");
	}

}
