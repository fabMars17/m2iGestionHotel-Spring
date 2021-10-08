package com.tpm2i.api;

import com.tpm2i.entities.Hotel;
import com.tpm2i.entities.Resa;
import com.tpm2i.services.HotelService;
import com.tpm2i.services.ResaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;

@RestController()
@RequestMapping("/api/resa")
public class ResaApiController {
    @Autowired
    ResaService rs;

    @GetMapping(path = "", produces = "application/json")
    public Iterable<Resa> getAll( HttpServletRequest request ){
        System.out.println( "\nVal recherchée = "+ request.getParameter("search") + "\n" );
        return rs.getListByClientName( request.getParameter("search") );
    }
    /*List<Resa> all() {
        return (List<Resa>) rs.getList();
    }*/

    @GetMapping(path="/{id}", produces = "application/json")
    Resa get( @PathVariable("id") int id ) {
        return rs.get(id);
    }

    @GetMapping(path="/byc", produces = "application/json")
    public Iterable<Resa> getAllByC(  ){
        //System.out.println( "\nVal recherchée = "+ request.getParameter("search") + "\n" );
        //return rs.getListByClient( request.getParameter("search") );
        //rs.checkDateResa( "Maire","Three Seasons Hotel London at Ten Trinity Square",56 );
        return rs.getListByClient( "Maire","a",56 );
    }


    @PostMapping(path = "", produces = "application/json")
    public ResponseEntity<Resa> addClientApi(@RequestBody Resa c) throws Exception {
        try{
            Resa createC = rs.add(c.getClient() , c.getHotel(), c.getDateStart(), c.getDateEnd(), c.getChambre());

            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(createC.getId())
                    .toUri();

            return ResponseEntity.created(uri) // created => HTTP 201
                    .body(createC);

        }catch ( Exception e ){
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST, "La reservation n'a pu etre faites"+e.getMessage() );
        }
    }

    @PutMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<Resa> editClientApi(@PathVariable("id") int id, @RequestBody Resa c) throws Exception {
        //try{
            Resa updatedC  = rs.edit(id, c.getClient() , c.getHotel(), c.getDateStart(), c.getDateEnd(), c.getChambre());

            return ResponseEntity.ok() // OK => HTTP 200
                    .body(updatedC);

        /*}catch ( Exception e ){
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST , "Ce Client n'a pu etre editer\n"+e.getMessage()  );
        }*/
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public void deleteClientApi(@PathVariable int id){
        rs.delete(id);
    }
}
