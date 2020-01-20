package com.ceue.rest.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Klasse für Bestellungen, erstellt eine Bestellung und verwaltet die einzelnen Komponenten
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bestellung {
    //Griff aus dem ERP
    private Griff griff;
    //Lenkertyp aus dem ERP
    private Lenkertyp lenkertyp;
    //Material aus dem ERP
    private Material material;
    //Schaltung aus dem ERP
    private Schaltung schaltung;

    /**
     * parameterloser Konstruktor
     */
    public Bestellung() { }

    /**
     * Setzt den Griff
     * @param griff der gewählte Griff
     */
    public void setGriff(Griff griff) {
        this.griff = griff;
    }

    /**
     * Setzt den Griff
     * @param lenkertyp der gewählte Lenkertyp
     */
    public void setLenkertyp(Lenkertyp lenkertyp) {
        this.lenkertyp = lenkertyp;
    }

    /**
     * Setzt den Griff
     * @param material das gewählte Material
     */
    public void setMaterial(Material material) {
        this.material = material;
    }

    /**
     * Setzt den Griff
     * @param schaltung die gewählte Schaltung
     */
    public void setSchaltung(Schaltung schaltung) {
        this.schaltung = schaltung;
    }

    /**
     * Liefert den Griff
     * @return der gewählte Griff
     */
    public Griff getGriff() {
        return this.griff;
    }

    /**
     * Liefert den Lenkertypen
     * @return der gewählte Lenkertyp
     */
    public Lenkertyp getLenkertyp() {
        return this.lenkertyp;
    }

    /**
     * Liefert das Material
     * @return das gewählte Material
     */
    public Material getMaterial() {
        return this.material;
    }

    /**
     * Liefert die Schaltung
     * @return die gewählte Schaltung
     */
    public Schaltung getSchaltung() {
        return this.schaltung;
    }

    /**
     * Gibt die gesamte Bestellung als String aus
     * @return die zusammengestellte Bestellung
     */
    @Override
    public String toString() {
        return this.lenkertyp + ", " + this.material + ", " + this.schaltung + ", " + this.griff;
    }
}