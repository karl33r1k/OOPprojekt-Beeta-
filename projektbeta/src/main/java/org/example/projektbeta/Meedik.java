package org.example.projektbeta;
import java.util.Random;

public class Meedik extends Karakter{ //Meedik klass - karakteri isendiväljade väärtused, temale eriline võime

    public Meedik(String nimi) {
        super(nimi);
        this.elud = 65;
        this.rynnakNum = 8;
        this.kaitseNum = 4;
        this.raviNum = 15;
        this.energia = 20;
    }
    public void erilinevoime(Vaenlane vaenlane){ //Meediku eriline võime annab talle energiat kulutades suure hulga elusid
        if(energia >= 70){
            energia -= 70;
            setElud(getElud()+50);
            System.out.println("Karakter sai 50 elu");
        }
        else {
            System.out.println("Teil ei ole piisavalt energiat, sind sunnitakse automaatselt puhkama");
            puhka();
        }
    }
}
