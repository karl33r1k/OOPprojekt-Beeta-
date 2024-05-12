package org.example.projektbeta;
import java.util.Random;

public abstract class Karakterid { //Määrab isendiväljad, konstruktor ,getElud/setElud
    public int elud;
    public String nimi;
    public int rynnakNum;
    public int kaitseNum;
    public int raviNum;

    public Karakterid(String nimi) {
        this.nimi = nimi;
    }

    public int getElud() {
        return elud;
    }

    public void setElud(int elud) {
        this.elud = elud;
    }
    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }
}
