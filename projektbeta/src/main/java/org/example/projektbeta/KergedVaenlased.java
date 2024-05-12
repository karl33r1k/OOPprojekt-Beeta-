package org.example.projektbeta;
import java.util.Random;

public abstract class KergedVaenlased extends Vaenlane {
    
    public KergedVaenlased(String nimi) {
        super(nimi);
    }
    @Override
    public void tegevus(Karakter karakter) {
        Random random = new Random();
        int suva3 = random.nextInt(0, 3); // otsustab, mida teeb vaenlane
        if (suva3 == 0) {
            rynda(karakter);
        } else if (suva3 == 1) {
            kaitse(karakter);
        } else if (suva3 == 2) {
            ravi();
        }
    }

}
