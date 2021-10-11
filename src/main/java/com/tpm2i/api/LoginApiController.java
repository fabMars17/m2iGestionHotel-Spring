package com.tpm2i.api;

import com.tpm2i.entities.User;
import com.tpm2i.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/login")
public class LoginApiController {

    /*@Autowired
    UserRepository userRepository;

    private static BCryptPasswordEncoder passwordEcorder = new BCryptPasswordEncoder();

    @PostMapping(path = "", produces = "application/json")
    ResponseEntity<User> checkLogin(@RequestBody User userv ){
        System.out.println( userv.getUserName() );
        try{
            User user = userRepository.findByUserName( userv.getUserName() );

            if( user != null && passwordEcorder.matches( userv.getPassword() , user.getPassword()) ){
                user.setPassword("");
                return ResponseEntity.ok() // ok => 200
                        .body(user);
            }else{
                throw new Exception( "Login ou password incorrect" );
            }
        }catch ( Exception e ){
            System.out.println("Je suis ici");
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST , e.getMessage() ); // KO : 400
        }
    }*/
    @Autowired
    private UserRepository ur;

    @PostMapping(path = "", produces = "application/json")
    ResponseEntity<User> checkLogin(@RequestBody User urs) {
        System.out.println( "username : " + urs.getUserName() );

        try{
            User user = ur.findByUserName( urs.getUserName() );
            user.setPassword("");
            return ResponseEntity.ok() // ok => 200
                    .body(user);

        }catch ( Exception e ){
            System.out.println("Je suis ici : Erreur Login Api exception");
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST ,  e.getMessage()+"probleme de Password depuis Angular"); // KO : 400e.getMessage()
        }
    }
}
