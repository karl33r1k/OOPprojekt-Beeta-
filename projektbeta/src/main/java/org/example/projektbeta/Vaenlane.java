package org.example.projektbeta;
import java.util.Random;

public abstract class Vaenlane extends Karakterid { // teeb sama, mis klass Karakter, aga suunab tegevused karakteri vastu
    public Vaenlane(String nimi) {
        super(nimi);
    }
    public void rynda(Karakter karakter) {
        System.out.println("Vaenlane otsustas rünnata");
    }
    public abstract void tegevus(Karakter karakter);
    public void kaitse(Karakter karakter) {
        System.out.println("Vaenlane otsustas kaitsta");
        Random random = new Random();
        int suvalinetagasilook = random.nextInt(0, kaitseNum) + 1;
        karakter.setElud(karakter.getElud() - suvalinetagasilook);
        setElud(getElud() + suvalinetagasilook);
        System.out.println("Vaenlane kaitses ennast, tehes sulle haiget: " + suvalinetagasilook + " ning ravis ennast sama palju");
    }
    public void ravi() {
        System.out.println("Vaenlane otsustas ravida");
        setElud(getElud() + raviNum);
        System.out.println("Vaenlane ravis ennast " + raviNum);
    }


    public String toString() {
        return "Vaenlase nimi: " + getNimi() +
                ", vaenlase elud: " + getElud();
    }
}
