package org.example.projektbeta;
import java.util.Random;

public class Hunt extends RaskedVaenlased {
    public Hunt(String nimi) {
        super(nimi);
        this.elud = 65;
        this.rynnakNum = 20;
        this.kaitseNum = 15;
        this.raviNum = 15; // suurem kaitse- ja ravinumber
    }

    @Override
    public void rynda(Karakter karakter) { // hundi rünnak teeb lisakahju
        super.rynda(karakter);
        karakter.setElud(karakter.getElud() - rynnakNum);
        System.out.println("Vaenlane ründas ja tegi haiget: " + rynnakNum + ", lisaks pani hundi rünnak sind veritsema");
        for (int i = 1; i <= 3; i++) {
            Random random = new Random();
            int suva = random.nextInt(1, 4);
            karakter.setElud(karakter.getElud() - suva);
            System.out.println("Veritsemine võttis sinult " + suva + " elu");
        }
    }

}
