package com.tpm2i.api;


import com.tpm2i.entities.Client;
import com.tpm2i.entities.Hotel;
import com.tpm2i.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController()
@RequestMapping("/api/hotel")
public class HotelApiController {

    @Autowired
    HotelService hs;

    @GetMapping(path = "", produces = "application/json")
    List<Hotel> all() {
        return (List<Hotel>) hs.getList();
    }

    @GetMapping(path="/{id}", produces = "application/json")
    Hotel get( @PathVariable("id") int id ) {
        return hs.get(id);
    }

    @PostMapping(path = "", produces = "application/json")
    public ResponseEntity<Hotel> addClientApi(@RequestBody Hotel c){
        try{
            Hotel createC = hs.add(c.getNom() , c.getEtoiles(), c.getAdresse(), c.getTelephone(), c.getEmail(),  c.getVille());

            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(createC.getId())
                    .toUri();

            return ResponseEntity.created(uri) // created => HTTP 201
                    .body(createC);

        }catch ( Exception e ){
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST , "Le Client n'a pu etre cree\n"+e.getMessage() );
        }
    }

    @PutMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<Hotel> editClientApi(@PathVariable("id") int id, @RequestBody Hotel c){
        try{
            Hotel updatedC  = hs.edit(id, c.getNom() , c.getEtoiles(), c.getAdresse(), c.getTelephone(), c.getEmail(),  c.getVille());

            return ResponseEntity.ok() // OK => HTTP 200
                    .body(updatedC);

        }catch ( Exception e ){
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST , "Ce Client n'a pu etre editer\n"+e.getMessage()  );
        }
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public void deleteClientApi(@PathVariable int id){
        hs.delete(id);
    }
}
