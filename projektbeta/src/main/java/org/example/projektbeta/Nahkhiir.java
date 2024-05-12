package org.example.projektbeta;
import java.util.Random;

public class Nahkhiir extends KergedVaenlased{
    int mitmeskord = 1;

    public Nahkhiir(String nimi) {
        super(nimi);
        this.elud = 25;
        this.rynnakNum = 15;
        this.kaitseNum = 5;
        this.raviNum = 6;
    }

    @Override
    public void rynda(Karakter karakter) {
        super.rynda(karakter);
        if ((mitmeskord % 3) == 0){
            karakter.setElud(karakter.getElud() - 20);
            System.out.println("Vaenlane viskas sind kiviga ja tegi haiget: 20" );
        } else {
            mitmeskord += 1;
            karakter.setElud(karakter.getElud() - rynnakNum);
            System.out.println("Vaenlane ründas ja tegi haiget: " + rynnakNum);
        }

    }
}
