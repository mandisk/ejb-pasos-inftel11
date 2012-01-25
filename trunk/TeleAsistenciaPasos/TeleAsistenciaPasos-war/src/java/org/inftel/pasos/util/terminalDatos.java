/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.util;

/**
 *
 * @author Frank
 */
public class terminalDatos {
    String trama;
    String alarma="";
    String ld="";
    String lh="";
    String ln="";
    String lt="";
    String pb="";
    String la="";
    String dt="";
    String rd="";

    public void terminalDatos() {
        this.trama="*$"+alarma+ld+lh+ln+lt+pb+la+dt+rd+"#";
    }
    
    public String getTrama() {
        return trama;
    }

    public void setTrama(String trama) {
        this.trama = trama;
    }
    
     public String getAlarma() {
        return alarma;
    }

    public void setAlarma(String alarma) {
        this.alarma = "AU"+alarma;
    }

    public String getLd() {
        return ld;
    }

    public void setLd(String ld) {
        this.ld = "&LD"+ld;
    }    
    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = "&DT"+dt;
    }

    public String getLa() {
        return la;
    }

    public void setLa(String la) {
        this.la = "&LA"+la;
    }

    public String getLh() {
        return lh;
    }

    public void setLh(String lh) {
        this.lh = "&LH"+lh;
    }

    public String getLn() {
        return ln;
    }

    public void setLn(String ln) {
        this.ln = "&LN"+ln;
    }

    public String getLt() {
        return lt;
    }

    public void setLt(String lt) {
        this.lt = "&#38LT"+lt;
    }

    public String getPb() {
        return pb;
    }

    public void setPb(String pb) {
        this.pb = "&PB"+pb;
    }
    
    public String getRd() {
        return rd;
    }

    public void setIm(String rd) {
        this.rd = "&RD"+rd;
    }
}
