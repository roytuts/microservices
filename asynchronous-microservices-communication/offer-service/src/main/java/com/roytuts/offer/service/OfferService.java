package com.roytuts.offer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.roytuts.offer.converter.DtoEntityConverter;
import com.roytuts.offer.dto.OfferDto;
import com.roytuts.offer.entity.Offer;
import com.roytuts.offer.repository.OfferRepository;

@Service
public class OfferService {

	@Value("${topic.name}")
	private String topicName;

	@Autowired
	private OfferRepository offerRepository;

	@Autowired
	private KafkaTemplate<String, OfferDto> kafkaTemplate;

	public OfferDto saveOffer(OfferDto offerDto) {
		Offer offer = offerRepository.saveAndFlush(DtoEntityConverter.offerDtoToOffer(offerDto));

		offerDto = DtoEntityConverter.offerToOfferDto(offer);

		kafkaTemplate.send(topicName, offerDto);

		return offerDto;
	}

}
