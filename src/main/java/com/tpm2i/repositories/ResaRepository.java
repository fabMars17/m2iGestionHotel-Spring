package com.tpm2i.repositories;

import com.tpm2i.entities.Resa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ResaRepository extends CrudRepository<Resa, Integer> {

    Iterable<Resa> findByClientNomContains(String nom);

    Iterable<Resa> findByClientNomContainsAndHotelNomAndChambre(String nom, String hotel, int chambre);
}
