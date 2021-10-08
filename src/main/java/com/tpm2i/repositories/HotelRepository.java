package com.tpm2i.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.tpm2i.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

}
