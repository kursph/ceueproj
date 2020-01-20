package com.ceue.rest.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Klasse für Kunde, erstellt einen Kunden
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Kunde {
    //Bezeichnung

    private String vorname;
    private String nachname;

    /**
     * Liefert den Vornamen
     * @return Vorname
     */
    public String getVorname() {
        return vorname;
    }


    /**
     * Liefert den Nachnamen
     * @return Nachname
     */
    public String getNachname() {
        return nachname;
    }

    /**
     * Setzt den Vornamen
     * @param vorname
     */
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    /**
     * Setzt den Nachnamen
     * @param nachname
     */
    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    /**
     * Gibt den Kunden als String aus
     * @return der Kunde
     */
    @Override
    public String toString() {
        return this.vorname + " " + this.nachname;
    }
}
