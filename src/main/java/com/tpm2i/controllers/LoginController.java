package com.tpm2i.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequestMapping("")
public class LoginController {
        @GetMapping("")
        public String dash(){
            return "dashboard.html";
        }

        @GetMapping("/login")
        public String login(){
            return "login.html";
        }

}
