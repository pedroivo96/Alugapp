package br.ufpi.alugapp.entidades;

import java.io.Serializable;

/**
 * Created by wellyson on 05/12/16.
 */

public class LocalMapa implements Serializable {

    private static final long serialVersionUID = 1L;

    public double latitude;
    public double longitude;

    public LocalMapa(double latitude, double longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
