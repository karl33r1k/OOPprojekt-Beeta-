package org.example.projektbeta;
import java.util.Random;

public class Vihmauss extends KergedVaenlased {
    int mitmeskord = 0;
    public Vihmauss(String nimi) {
        super(nimi);
        this.elud = 30;
        this.rynnakNum = 10;
        this.kaitseNum = 8;
        this.raviNum = 7;
    }

    @Override
    public void rynda(Karakter karakter) {
        super.rynda(karakter);
        if (mitmeskord == 0){
            mitmeskord += 1;
            karakter.setElud(karakter.getElud() - (rynnakNum*2));
            System.out.println("Vihmauss hiilis ja tegi sulle üllatusrünnaku");
            System.out.println("Vaenlane ründas ja tegi haiget: " + (rynnakNum*2));
        }
        else {
            mitmeskord += 1;
            karakter.setElud(karakter.getElud() - rynnakNum);
            System.out.println("Vaenlane ründas ja tegi haiget: " + rynnakNum);
        }
    }

}
