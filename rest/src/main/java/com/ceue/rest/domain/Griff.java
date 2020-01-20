package com.ceue.rest.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Klsse für Griffe, erstellt einen Griff
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Griff {
    //Bezeichnung
    private String name;

    /**
     * Konstruktor
     * @param _name die gewählte Bezeichnung
     */
    public Griff(String _name) {
        this.name = _name;
    }

    /**
     * Liefert die Bezeichnung
     * @return die gewählte Bezeichnung
     */
    public String getName() {
        return name;
    }

    /**
     * Setzt die Bezeichnung
     * @param _name die gewählte Bezeichnung
     */
    public void setName(String _name) {
        this.name = _name;
    }

    /**
     * Gibt den Griff als String aus
     * @return der Griff
     */
    @Override
    public String toString() {
        return this.name;
    }
}