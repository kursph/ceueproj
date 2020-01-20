package com.ceue.rest.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Klasse für Schaltungen, erstellt eine Schaltung
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Schaltung {
    //Bezeichnung
    private String name;

    /**
     * Konstruktor
     * @param _name die gewählte Bezeichnung
     */
    public Schaltung(String _name) {
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
     * Gibt die Schaltung als String aus
     * @return die Schaltung
     */
    @Override
    public String toString() {
        return this.name;
    }
}
