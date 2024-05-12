package org.example.projektbeta;
import java.util.Random;

public class Vibulaskja extends Karakter{ //Vibulaskja klass - karakteri isendiväljade väärtused,karakterile omane ründamismuster ehk ründamise meetod, temale eriline võime

    public Vibulaskja(String nimi) {
        super(nimi);
        this.elud = 50;
        this.rynnakNum = 10;
        this.kaitseNum = 8;
        this.raviNum = 6;
        this.energia = 10;
    }
    public void rynda(Vaenlane vaenlane) { //ründab kolm korda
        System.out.println("Karakter ründab");
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int rynnak = random.nextInt(0,rynnakNum)+1;
            vaenlane.setElud(vaenlane.getElud() - rynnak);
            System.out.println("Vibulaskja " + (i+1) + ". rünnak tegi vaenlasele valu: " + rynnak);
        }
    }
    public void erilinevoime(Vaenlane vaenlane) { //Kulutades energiat on 10% tõenäosus, et teeb vastasele 100 ühiku eest haiget. Kui ebaõnnestub, siis teeb haiget ainult 1 ühiku eest.
        Random random = new Random();
        int suvalineNum = random.nextInt(0, 10);
        if (energia >= 70) {
            if (suvalineNum == 0) {
                vaenlane.setElud(vaenlane.getElud() - 100);
                System.out.println("Karakter kasutas oma supervõimet, see õnnestus ja tegi vastasele haiget: 100");
            } else {
                vaenlane.setElud(vaenlane.getElud() - 1);
                System.out.println("Karakter kasutas oma supervõimet, see ebaõnnestus ja tegi vastasele haiget: 1");
            }
        } else {
            System.out.println("Teil ei ole piisavalt energiat, sind sunnitakse automaatselt puhkama");
            puhka();
        }
    }
}
