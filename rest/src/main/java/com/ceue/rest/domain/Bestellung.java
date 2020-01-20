package com.ceue.rest.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

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

    /**
     * Methode um die Bestellung an das ERP abzuschicken
     * @throws IOException
     */
    public boolean bestellungSenden() throws IOException{
        URL object = new URL("https://www.maripavi.at/bestellung");
        HttpURLConnection con = (HttpURLConnection) object.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        String POST_PARAMS = "griff="+lenkertyp+"&lenkertyp="+lenkertyp+"&material="+material+"&schaltung="+schaltung;
        con.setDoOutput(true);
        OutputStream os = con.getOutputStream();
        os.write(POST_PARAMS.getBytes());
        os.flush();
        os.close();
        int responseCode = con.getResponseCode();
        if(responseCode==201){
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()
            ));
            String lineInput;
            StringBuffer sb = new StringBuffer();
            while((lineInput = in.readLine()) != null){
                sb.append(lineInput);
            }
            in.close();
            System.out.println("POST erfolgreich");
            return true;
        }else{
            System.out.println("POST nicht erfolgreich");
            return false;
        }
    }
}