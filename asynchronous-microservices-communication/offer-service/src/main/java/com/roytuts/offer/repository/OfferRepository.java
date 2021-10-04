package com.roytuts.offer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roytuts.offer.entity.Offer;

public interface OfferRepository extends JpaRepository<Offer, Integer> {

}
