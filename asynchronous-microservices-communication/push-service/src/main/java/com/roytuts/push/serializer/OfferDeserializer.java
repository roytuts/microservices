package com.roytuts.push.serializer;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.roytuts.push.dto.OfferDto;

public class OfferDeserializer implements Deserializer<OfferDto> {

	@Override
	public void close() {

	}

	@Override
	public OfferDto deserialize(String s, byte[] bytes) {
		ObjectMapper mapper = new ObjectMapper();
		OfferDto offerDto = null;

		try {
			offerDto = mapper.readValue(bytes, OfferDto.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return offerDto;
	}

}
