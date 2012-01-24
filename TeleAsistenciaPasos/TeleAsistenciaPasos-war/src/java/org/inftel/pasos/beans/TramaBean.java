/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.beans;

import java.io.Serializable;

/**
 *
 * @author inftel
 */
public class TramaBean implements Serializable {

    private int date;
    private int hora;
    private int lon;
    private int lat;
    private int pb;
    private int alt;
    private int temp;
    private long Imei;

    public TramaBean() {
    }

    public long getImei() {
        return Imei;
    }

    public void setImei(long Imei) {
        this.Imei = Imei;
    }

    public int getAlt() {
        return alt;
    }

    public void setAlt(int alt) {
        this.alt = alt;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public int getLon() {
        return lon;
    }

    public void setLon(int lon) {
        this.lon = lon;
    }

    public int getPb() {
        return pb;
    }

    public void setPb(int pb) {
        this.pb = pb;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}
