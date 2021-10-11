package com.tpm2i.services;

import com.tpm2i.entities.Client;
import com.tpm2i.entities.Hotel;
import com.tpm2i.entities.Resa;
import com.tpm2i.repositories.HotelRepository;
import com.tpm2i.repositories.ResaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;
import java.util.Iterator;

@Service
public class ResaService {
    ResaRepository rr ;

    ResaService(ResaRepository r){this.rr=r;}

    public Iterable<Resa> getList() {
        return rr.findAll();
    }

    public Resa add(Client client, Hotel hotel, Date datestart, Date dateend, int chambre) throws Exception {

        System.out.println(datestart+" date form Angular form");
        System.out.println(dateend+" date form Angular form");
        checkDateResaParadox( datestart, dateend);

        Resa c=new Resa();

        c.setClient(client);
        c.setHotel(hotel);
        c.setDateStart(datestart);
        c.setDateEnd(dateend);
        c.setChambre(chambre);

        //checkResa( c );

        rr.save(c);
        //} else {
        //    throw new Exception("Please, Choose another date !");
        //}

        return c;
    }

    public Resa edit(int id, Client client, Hotel hotel, Date datestart, Date dateend, int chambre) throws Exception {
        Resa c = rr.findById(id).get();
        checkDateResaParadox( datestart, dateend);
        if(checkDateResaOverlap(id, datestart, dateend, client.getNom(), hotel.getNom(), chambre )) {

            c.setClient(client);
            c.setHotel(hotel);
            c.setDateStart(datestart);
            c.setDateEnd(dateend);
            c.setChambre(chambre);

            rr.save(c);
        }
        return c;
    }

    public Resa get(int id){

        Optional<Resa> c;
        c = rr.findById(id);

        return c.get();
    }

    public void delete(int id){
        rr.deleteById(id);
    }

    public Iterable<Resa> getListByClientName( String search ){
        if( search == null || search.length() < 2 ){
            return rr.findAll();
        }else{
            return rr.findByClientNomContains(search );
        }
    }

    public Iterable<Resa> getListByClient( String search, String hotel, int d ){
        if( search == null || search.length() == 0 ){
            return rr.findAll();
        }else{
            //return rr.findByClientNomContains(search );
            return rr.findByClientNomContainsAndHotelNomAndChambre(search, hotel, d );
        }
    }

    public boolean checkDateResaOverlap(int id, Date datestart,Date dateend, String search, String hotel, int d ) throws Exception {
        Iterable<Resa> a = rr.findByClientNomContainsAndHotelNomAndChambre(search, hotel, d );//getListByClient( search,  hotel,  d );
        // check if id is not the actual id, to avoid to check himself
        for(Resa s: a){
            Date dda = s.getDateStart();
            Date ddb = s.getDateEnd();
            /*System.out.println(s.getId()+" Match Loop");
            System.out.println(dda+" from iterable");
            System.out.println(datestart+" from Angular");
            System.out.println(dda.getTime());
            System.out.println(datestart.getTime());*/
            if( (datestart.before(ddb) && datestart.after(dda)) || (dateend.before(ddb) && dateend.after(dda)) || (datestart.before(dda) && dateend.after(ddb)) )
            {
                System.out.println("There is date overlap, Choose another date");
                throw new Exception("There is date overlap, Choose another date");
                //return false;
            }
        }
        System.out.println(" there is no some Equals");
        return true;
    }

    public void checkDateResaParadox(Date dates, Date datee) throws Exception {
        if(dates.after(datee)){
            throw new Exception("Date1 is after Date2");
        }

        if(dates.equals(datee)){
            throw new Exception("Date1 is equal Date2");
        }
    }

    public ResponseEntity checkResa( Resa resa ) throws Exception {
       String r="";
        try {
           resa.getClient().getClass();
        } catch (Exception e) {
           //throw new Exception(e.getCause()+" Aucun Client selectionner");
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
            //r+=e.getMessage();
            //r+="Aucun Client selectionner\n";
        }
        finally {
            try {
                resa.getHotel().getClass();
            } catch (NullPointerException e) {
                //throw new Exception("Aucun Hotel selectionner");
                r+="Aucun Hotel selectionner\n";
                r+=e.getMessage();
            }
            finally {
                if(resa.getChambre()==0)   {r+="Aucun Chambre selectionner\n";}
            }
        }

        if(r.length()!= 0) {
            throw new Exception(r);
        }
        return new ResponseEntity<String>(HttpStatus.ACCEPTED);
    }
}
