package com.roytuts.offer.converter;

import com.roytuts.offer.dto.OfferDto;
import com.roytuts.offer.entity.Offer;

public final class DtoEntityConverter {

	private DtoEntityConverter() {
	}

	public static Offer offerDtoToOffer(OfferDto offerDto) {
		Offer offer = new Offer();
		offer.setId(offerDto.getId());
		offer.setCode(offerDto.getCode());
		offer.setDescription(offerDto.getDescription());

		return offer;
	}

	public static OfferDto offerToOfferDto(Offer offer) {
		OfferDto offerDto = new OfferDto();
		offerDto.setId(offer.getId());
		offerDto.setCode(offer.getCode());
		offerDto.setDescription(offer.getDescription());

		return offerDto;
	}

}
