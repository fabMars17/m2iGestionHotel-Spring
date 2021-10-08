package com.tpm2i.api;

import com.tpm2i.entities.Client;
import com.tpm2i.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.lang.ref.Cleaner;
import java.net.URI;
import java.util.List;

@RestController()
@RequestMapping("/api/client")
public class ClientApiController {

    @Autowired
    ClientService cs;

    @GetMapping(path = "", produces = "application/json")
    List<Client> all() {
        return (List<Client>) cs.getList();
    }

    @GetMapping(path="/{id}", produces = "application/json")
    Client get( @PathVariable("id") int id ) {
        return cs.get(id);
    }

    @PostMapping(path = "", produces = "application/json")
    public ResponseEntity<Client> addClientApi(@RequestBody Client c){
        try{
            Client createC = cs.add(c.getNom() , c.getTelephone(), c.getEmail(), c.getAdresse() );

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
    public ResponseEntity<Client> editClientApi(@PathVariable("id") int id, @RequestBody Client c){
        try{
            Client updatedC  = cs.edit(id, c.getNom(), c.getTelephone() ,  c.getEmail(), c.getAdresse());

            return ResponseEntity.ok() // OK => HTTP 200
                    .body(updatedC);

        }catch ( Exception e ){
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST , "Ce Client n'a pu etre editer\n"+e.getMessage()  );
        }
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public void deleteClientApi(@PathVariable int id){
        cs.delete(id);
    }
}
