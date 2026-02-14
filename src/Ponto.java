/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author WIN10
 */
import java.io.Serializable;

public class Ponto implements Serializable {
    private static final long serialVersionUID = 1L;

    int log;
    int lat;

    public Ponto(int log, int lat) {
        this.log = log;
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "(" + log + ", " + lat + ")";
    }
}


