package com.ceue.rest.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class KundeController {

    @RequestMapping("/kunde")
    public String createKunde(@RequestParam(value = "vorname")String vorname, @RequestParam(value="nachname") String nachname){
        return "Kunde " + vorname + " " + nachname + " erstellt. <br /><a href=\"lenker\">Continue here</a>";
    }

}
