
package Annata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Mesi {

    @SerializedName("Gennaio")
    @Expose
    private Gennaio gennaio;
    @SerializedName("Febbraio")
    @Expose
    private Febbraio febbraio;
    @SerializedName("Marzo")
    @Expose
    private Marzo marzo;
    @SerializedName("Aprile")
    @Expose
    private Aprile aprile;
    @SerializedName("Maggio")
    @Expose
    private Maggio maggio;
    @SerializedName("Giugno")
    @Expose
    private Giugno giugno;
    @SerializedName("Luglio")
    @Expose
    private Luglio luglio;
    @SerializedName("Agosto")
    @Expose
    private Agosto agosto;
    @SerializedName("Settembre")
    @Expose
    private Settembre settembre;
    @SerializedName("Ottobre")
    @Expose
    private Ottobre ottobre;
    @SerializedName("Novembre")
    @Expose
    private Novembre novembre;
    @SerializedName("Dicembre")
    @Expose
    private Dicembre dicembre;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Mesi() {
    }

    /**
     * 
     * @param agosto
     * @param settembre
     * @param giugno
     * @param gennaio
     * @param febbraio
     * @param luglio
     * @param ottobre
     * @param aprile
     * @param dicembre
     * @param novembre
     * @param maggio
     * @param marzo
     */
    public Mesi(Gennaio gennaio, Febbraio febbraio, Marzo marzo, Aprile aprile, Maggio maggio, Giugno giugno, Luglio luglio, Agosto agosto, Settembre settembre, Ottobre ottobre, Novembre novembre, Dicembre dicembre) {
        super();
        this.gennaio = gennaio;
        this.febbraio = febbraio;
        this.marzo = marzo;
        this.aprile = aprile;
        this.maggio = maggio;
        this.giugno = giugno;
        this.luglio = luglio;
        this.agosto = agosto;
        this.settembre = settembre;
        this.ottobre = ottobre;
        this.novembre = novembre;
        this.dicembre = dicembre;
    }

    public Gennaio getGennaio() {
        return gennaio;
    }

    public void setGennaio(Gennaio gennaio) {
        this.gennaio = gennaio;
    }

    public Mesi withGennaio(Gennaio gennaio) {
        this.gennaio = gennaio;
        return this;
    }

    public Febbraio getFebbraio() {
        return febbraio;
    }

    public void setFebbraio(Febbraio febbraio) {
        this.febbraio = febbraio;
    }

    public Mesi withFebbraio(Febbraio febbraio) {
        this.febbraio = febbraio;
        return this;
    }

    public Marzo getMarzo() {
        return marzo;
    }

    public void setMarzo(Marzo marzo) {
        this.marzo = marzo;
    }

    public Mesi withMarzo(Marzo marzo) {
        this.marzo = marzo;
        return this;
    }

    public Aprile getAprile() {
        return aprile;
    }

    public void setAprile(Aprile aprile) {
        this.aprile = aprile;
    }

    public Mesi withAprile(Aprile aprile) {
        this.aprile = aprile;
        return this;
    }

    public Maggio getMaggio() {
        return maggio;
    }

    public void setMaggio(Maggio maggio) {
        this.maggio = maggio;
    }

    public Mesi withMaggio(Maggio maggio) {
        this.maggio = maggio;
        return this;
    }

    public Giugno getGiugno() {
        return giugno;
    }

    public void setGiugno(Giugno giugno) {
        this.giugno = giugno;
    }

    public Mesi withGiugno(Giugno giugno) {
        this.giugno = giugno;
        return this;
    }

    public Luglio getLuglio() {
        return luglio;
    }

    public void setLuglio(Luglio luglio) {
        this.luglio = luglio;
    }

    public Mesi withLuglio(Luglio luglio) {
        this.luglio = luglio;
        return this;
    }

    public Agosto getAgosto() {
        return agosto;
    }

    public void setAgosto(Agosto agosto) {
        this.agosto = agosto;
    }

    public Mesi withAgosto(Agosto agosto) {
        this.agosto = agosto;
        return this;
    }

    public Settembre getSettembre() {
        return settembre;
    }

    public void setSettembre(Settembre settembre) {
        this.settembre = settembre;
    }

    public Mesi withSettembre(Settembre settembre) {
        this.settembre = settembre;
        return this;
    }

    public Ottobre getOttobre() {
        return ottobre;
    }

    public void setOttobre(Ottobre ottobre) {
        this.ottobre = ottobre;
    }

    public Mesi withOttobre(Ottobre ottobre) {
        this.ottobre = ottobre;
        return this;
    }

    public Novembre getNovembre() {
        return novembre;
    }

    public void setNovembre(Novembre novembre) {
        this.novembre = novembre;
    }

    public Mesi withNovembre(Novembre novembre) {
        this.novembre = novembre;
        return this;
    }

    public Dicembre getDicembre() {
        return dicembre;
    }

    public void setDicembre(Dicembre dicembre) {
        this.dicembre = dicembre;
    }

    public Mesi withDicembre(Dicembre dicembre) {
        this.dicembre = dicembre;
        return this;
    }

}
