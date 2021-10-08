package com.tpm2i.services;

import com.tpm2i.entities.Client;
import com.tpm2i.repositories.ClientRepository;
import com.tpm2i.repositories.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
   ClientRepository cr;

    ClientService(ClientRepository c){this.cr=c;}

    public Iterable<Client> getList() {
        return cr.findAll();
    }

    public Client add(String nomcomplet,String telephone,String email,String adresse){

        Client c = new Client();
        c.setNom(nomcomplet);
        c.setTelephone(telephone);
        c.setEmail(email);
        c.setAdresse(adresse);
        cr.save(c);

        return c;
    }

    public Client edit(int id, String nomcomplet,String telephone,String email,String adresse){

        Client c = cr.findById(id).get();
        c.setNom(nomcomplet);
        c.setTelephone(telephone);
        c.setEmail(email);
        c.setAdresse(adresse);
        cr.save(c);

        return c;
    }

    public Client get(int id){

        Optional<Client> c;
        c = cr.findById(id);

        return c.get();
    }

    public void delete(int id){
        cr.deleteById(id);
    }
}
