package org.example.projektbeta;
import java.util.Random;

public abstract class RaskedVaenlased extends Vaenlane { // raskematel vaenlastel on suurem tõenäosus, et nad ründavad
    public RaskedVaenlased(String nimi) {
        super(nimi);
    }

    @Override
    public void tegevus(Karakter karakter) {
        Random random = new Random();
        int suva3 = random.nextInt(0, 4); // otsustab, mida teeb vaenlane
        if (suva3 == 0 || suva3 == 3) {
            rynda(karakter);
        } else if (suva3 == 1) {
            kaitse(karakter);
        } else if (suva3 == 2) {
            ravi();
        }
    }

}
