package org.example.projektbeta;
import java.util.Random;

public class Draakon extends RaskedVaenlased {
    private int mitmesrynnak;
    public Draakon(String nimi) {
        super(nimi);
        this.mitmesrynnak = 0;
        this.elud = 80;
        this.rynnakNum = 35;
        this.kaitseNum = 12;
        this.raviNum = 10;
    }

    @Override
    public void rynda(Karakter karakter) { // iga kolmas rünnak on tugevam
        mitmesrynnak++;
        if (mitmesrynnak % 3 == 0) {
            karakter.setElud(karakter.getElud() - (rynnakNum + 10));
            System.out.println("Vaenlane purskas sinu suunas tuld ja vähendas sinu elusid 45 võrra.");
        } else {
            karakter.setElud(karakter.getElud() - rynnakNum);
            System.out.println("Vaenlane ründas sind ja vähendas sinu elusid 35 võrra.");
        }
    }

}
