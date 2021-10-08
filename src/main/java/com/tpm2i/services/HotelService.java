package com.tpm2i.services;

import com.tpm2i.entities.Client;
import com.tpm2i.entities.Hotel;
import com.tpm2i.repositories.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class HotelService {
    HotelRepository hr;

    HotelService(HotelRepository h){this.hr=h;}

    public Iterable<Hotel> getList() {
        return hr.findAll();
    }

    public Hotel add(String nom,int etoile, String adresse, String telephone, String email, String ville){

        Hotel c = new Hotel();
        c.setNom(nom);
        c.setEtoiles(etoile);
        c.setAdresse(adresse);
        c.setTelephone(telephone);
        c.setEmail(email);
        c.setVille(ville);
        hr.save(c);

        return c;
    }

    public Hotel edit(int id, String nom,int etoile, String adresse, String telephone, String email, String ville){

        Hotel c = hr.findById(id).get();
        c.setNom(nom);
        c.setEtoiles(etoile);
        c.setAdresse(adresse);
        c.setTelephone(telephone);
        c.setEmail(email);
        c.setVille(ville);
        hr.save(c);

        return c;
    }

    public Hotel get(int id){

        Optional<Hotel> c;
        c = hr.findById(id);

        return c.get();
    }

    public void delete(int id){
        hr.deleteById(id);
    }
}
