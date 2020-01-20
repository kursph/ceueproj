package com.ceue.rest.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Klasse für Lenkertypen, erstellt einen Lenktertpyen
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Lenkertyp {
    //Bezeichnung
    private String name;

    /**
     * Konstruktor
     * @param _name die gewählte Bezeichnung
     */
    public Lenkertyp(String _name) {
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
     * Gibt den Lenkertypen als String aus
     * @return der Lenkertyp
     */
    @Override
    public String toString() {
        return this.name;
    }
}
