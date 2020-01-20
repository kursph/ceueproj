package com.ceue.rest.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Klasse für Materialien, erstellt ein Material
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Material {
    //Bezeichnung
    private String name;

    /**
     * Konstruktor
     * @param _name die gewählte Bezeichnung
     */
    public Material(String _name) {
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
     * Gibt das Matrial als String aus
     * @return das Material
     */
    @Override
    public String toString() {
        return this.name;
    }
}
