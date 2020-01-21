package com.ceue.rest.controller;

import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class KundeController {

    @RequestMapping(path ="/kunde",  method= POST)
    public String createKunde(@RequestParam(value = "vorname")String vorname, @RequestParam(value="nachname") String nachname){
        return "Kunde " + vorname + " " + nachname + " erstellt. <br /><a href=\"lenker\">Continue here</a>";
    }

}
