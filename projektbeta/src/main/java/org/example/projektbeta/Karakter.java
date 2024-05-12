package org.example.projektbeta;
import java.util.Random;

public abstract class Karakter extends Karakterid { //Lisab isendivälja energia (karakterite eripära), puhkab meetodi ning tegevusmeetodid vaenlaste vastu, toString väljastus karakteri andmetega
    public int energia;
    public Karakter(String nimi) {
        super(nimi);
    }

    public void puhka(){
        Random random = new Random();
        int suvalineenergia = random.nextInt(0,51);
        energia += suvalineenergia;
        System.out.println("Karakter sai: " + suvalineenergia + " energiat");
    }
    public void rynda(Vaenlane vaenlane) {

        System.out.println("Karakter ründab");
        vaenlane.setElud(vaenlane.getElud() - rynnakNum);
        System.out.println("Karakter ründas: " + rynnakNum);
    }
    public void kaitse(Vaenlane vaenlane) {
        Random random = new Random();
        int suvalinetagasilook = random.nextInt(0,kaitseNum) + 1;
//        System.out.println("Kaitse number on " + getKaitseNum());
        vaenlane.setElud(vaenlane.getElud() - suvalinetagasilook);
        setElud(getElud()+suvalinetagasilook);
        System.out.println("Karakter kaitses ennast ning tegi vastasele haiget: " + suvalinetagasilook + " ning ravis ennast sama palju");
    }
    public void ravi() {
        System.out.println("Karakter ravib");
        setElud(getElud()+raviNum);
    }
    public abstract void erilinevoime(Vaenlane vaenlane);
    @Override
    public String toString() {
        return "Karakteri nimi: " + nimi +
                ", karakteri elud: " + elud +
                ", karakteri energia: " + energia;
    }
}
