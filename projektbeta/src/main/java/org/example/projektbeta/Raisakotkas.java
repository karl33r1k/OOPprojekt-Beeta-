package org.example.projektbeta;
import java.util.Random;

public class Raisakotkas extends RaskedVaenlased {

    public Raisakotkas(String nimi) {
        super(nimi);
        this.elud = 50;
        this.rynnakNum = 30;
        this.kaitseNum = 12;
        this.raviNum = 10;
    }

    @Override
    public void rynda(Karakter karakter) { // saab rünnates elusid tagasi
        super.rynda(karakter);
        setElud(getElud() + 8);
        karakter.setElud(karakter.getElud() - rynnakNum);
        System.out.println("Vaenlane ründas ja tegi haiget: " + rynnakNum + ", lisaks sai tagasi 15 elu");
    }

}
