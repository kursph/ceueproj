package com.ceue.rest.controller;

import com.ceue.rest.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Controller entsprechend Spring Boot MVC
 * root --> localhost:8080/
 * wird mit index.html dargestellt
 */
@Controller
@RequestMapping("/")
public class LenkerController {
    //Template für die CRUD Methoden
    @Autowired
    private RestTemplate restTemplate;

    //die Bestellung vom User
    private Bestellung bestellung = new Bestellung();

    /**
     * Liefert alle Lenkertypen vom ERP
     * @param model Model entsprechend Spring Boot MVC
     * @return Zieladresse
     */
    @GetMapping(path = "/lenker", produces = "application/json")
    public String getAllHandlebars(Model model) {
        //der benötigte REST API Endpoint
        String url = "https://www.maripavi.at/produkt/lenkertyp";
        //Objekte aus der JSON response als String parsen
        String[] objects = restTemplate.getForObject(url, String[].class);

        Lenkertyp[] lenker = new Lenkertyp[objects.length];
        int i = 0;

        for(Object object : objects) {
            Lenkertyp temp = new Lenkertyp(object.toString());
            lenker[i] = temp;
            i++;
        }

        //Attribut durch Model verfügbar für View machen
        model.addAttribute("lenker", Arrays.asList(lenker));
        //Angabe der Zieladresse im Templateordner für Thymeleaf
        return "lenker";
    }

    /**
     * Liefert alle Materalien vom ERP
     * @param model Model entsprechend Spring Boot MVC
     * @param lenker übergebener Parameter
     * @return Zieladresse
     */
    @GetMapping(path = "/material", produces = "application/json")
    public String getAllMaterials(@RequestParam(name = "lenker") String lenker, Model model) {
        //für die Abhängigkeiten wird der Parameter vom Lenkertypen übergeben
        String url = "https://www.maripavi.at/produkt/material?lenkertyp=" + lenker + "";
        String[] objects = restTemplate.getForObject(url, String[].class);

        //erstellt den Lenkertypen entsprechen dem Parameter und fügt ihn der Bestellung hinzu
        Lenkertyp lenkertyp = new Lenkertyp(lenker);
        bestellung.setLenkertyp(lenkertyp);

        Material[] materials = new Material[objects.length];
        int i = 0;

        for(Object object : objects) {
            Material temp = new Material(object.toString());
            materials[i] = temp;
            i++;
        }

        model.addAttribute("material", Arrays.asList(materials));
        return "materiale";
    }

    /**
     * Liefert alle Schaltungen vom ERP
     * @param model Model entsprechend Spring Boot MVC
     * @param mater übergebener Parameter
     * @return Zieladresse
     */
    @GetMapping(path = "/schaltung", produces = "application/json")
    public String getAllGearLevers(@RequestParam(name = "material") String mater, Model model) {
        String url = "https://www.maripavi.at/produkt/schaltung?lenkertyp=" + bestellung.getLenkertyp().getName() + "";
        String[] objects = restTemplate.getForObject(url, String[].class);

        Material material = new Material(mater);
        bestellung.setMaterial(material);

        Schaltung[] schaltungen = new Schaltung[objects.length];
        int i = 0;

        for(Object object : objects) {
            Schaltung temp = new Schaltung(object.toString());
            schaltungen[i] = temp;
            i++;
        }

        model.addAttribute("schaltung", Arrays.asList(schaltungen));
        return "schaltungen";
    }

    /**
     * Liefert alle Griffe vom ERP
     * @param model Model entsprechend Spring Boot MVC
     * @param schalt übergebener Parameter
     * @return Zieladresse
     */
    @GetMapping(path = "/griffe", produces = "application/json")
    public String getAllHandles(@RequestParam(name = "schaltung") String schalt, Model model) {
        String url = "https://www.maripavi.at/produkt/griff?material=" + bestellung.getMaterial().getName() + "";
        String[] objects = restTemplate.getForObject(url, String[].class);

        Schaltung schaltung = new Schaltung(schalt);
        bestellung.setSchaltung(schaltung);

        Griff[] griffe = new Griff[objects.length];
        int i = 0;

        for(Object object : objects) {
            Griff temp = new Griff(object.toString());
            griffe[i] = temp;
            i++;
        }

        model.addAttribute("griffe", Arrays.asList(griffe));
        return "griffe";
    }
    /**
     * erstellt eine neue Bestellung für das ERP
     * @param model Model entsprechend Spring Boot MVC
     * @param griffe übergebener Parameter
     * @return Zieladresse
     */
    @GetMapping(path = "/bestellung", produces = "application/json")
    public String addBestellung(@RequestParam(name = "griffe") String griffe, Model model) {
        String url = "https://www.maripavi.at/produkt/bestellung";

        Griff griff = new Griff(griffe);
        bestellung.setGriff(griff);
        model.addAttribute("bestellung", bestellung);

        return "bestellung";
    }
}