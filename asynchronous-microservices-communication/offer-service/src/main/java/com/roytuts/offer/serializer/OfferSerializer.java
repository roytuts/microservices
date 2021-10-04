package com.roytuts.offer.serializer;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.roytuts.offer.dto.OfferDto;

public class OfferSerializer implements Serializer<OfferDto> {

	@Override
	public void close() {

	}

	@Override
	public byte[] serialize(String s, OfferDto offerDto) {
		byte[] retVal = null;
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			retVal = objectMapper.writeValueAsString(offerDto).getBytes();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return retVal;
	}

}
