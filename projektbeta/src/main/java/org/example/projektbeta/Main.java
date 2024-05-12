package org.example.projektbeta;
import java.util.Random;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // kasutajalt info küsimine
        System.out.println("Sisesta enda karakteri nimi: ");
        String nimi = scanner.nextLine();
        System.out.println("Sisesta karakteri tüüp: ");
        System.out.println("Valikud on: 'Sõdur', 'Meedik', 'Vibulaskja'");
        String tüüp = scanner.nextLine();
        System.out.println("Sisesta raskusaste: ");
        System.out.println("Valikud on: 'Kerge', 'Raske'");
        String raskusaste = scanner.nextLine();

        Karakter karakter = karakterityyp(nimi, tüüp); // karakteri loomine vastavalt valitud tüübile ja raskusastmele

        int skoor = 0;

        while (true) {
            if (karakter.getElud() <= 0) { // kui karakteri elud saavad otsa, kuvatakse skoor
                System.out.println(nimi + " saavutas " + skoor + " punkti");
                break;
            }
            Random random = new Random();
            Vaenlane vaenlane = vaenlased(raskusaste); // suvalise vaenlase saamine
            int suva2 = random.nextInt(0, 2); // määrab, kas esimesena alustab mängija või vaenlane
            if (vaenlane.getNimi().contains("kiire") || suva2 == 0) {
                while(vaenlane.getElud() > 0) {
                    if (karakter.getElud() > 0 && vaenlane.getElud() > 0) {
                        vaenlane.tegevus(karakter);
                        System.out.println(vaenlane);
                        System.out.println(karakter); // mängija käik
                        System.out.println("Valikud on: '1' - ründa, '2' - kaitse, '3' - ravi, '4', puhka, '5' - supervõime");
                        System.out.println("Sisesta valik: ");
                        String valik = scanner.nextLine();

                        switch (valik) {
                            case "1" -> karakter.rynda(vaenlane);
                            case "2" -> karakter.kaitse(vaenlane);
                            case "3" -> karakter.ravi();
                            case "4" -> karakter.puhka();
                            case "5" -> karakter.erilinevoime(vaenlane);
                        }

                    } else {
                        break;
                    }
                }
            }
            else if (suva2 == 1) { // kui on 1, alustab mängija
                while(vaenlane.getElud() > 0) {
                    if (karakter.getElud() > 0 && vaenlane.getElud() > 0) {
                        System.out.println(karakter);
                        System.out.println(vaenlane);
                        System.out.println("Valikud on: '1' - ründa, '2' - kaitse, '3' - ravi, '4', puhka, '5' - supervõime");
                        System.out.println("Sisesta valik: ");
                        String valik = scanner.nextLine();

                        switch (valik) {
                            case "1" -> karakter.rynda(vaenlane);
                            case "2" -> karakter.kaitse(vaenlane);
                            case "3" -> karakter.ravi();
                            case "4" -> karakter.puhka();
                            case "5" -> karakter.erilinevoime(vaenlane);
                        }
                        vaenlane.tegevus(karakter); // vaenlase käik
                    } else {
                        break;
                    }
                }
            }
            if (vaenlane.getElud() <= 0 && karakter.getElud() > 0) { // skoori kasvatamine
                skoor += skoorisysteem(vaenlane);
                System.out.println("Võitsid vastase " + vaenlane.getNimi() + " vastu. Sind ootab ees uus vastane.");
                System.out.println();
            }
        }
    }
        public static Karakter karakterityyp(String nimi, String tüüp) { // määrab karakteri tüübi
            Karakter karakter = null;
            if (tüüp.equals("Sõdur")) {
                karakter = new Sõdur(nimi);
            } else if (tüüp.equals("Meedik")) {
                karakter = new Meedik(nimi);
            } else if (tüüp.equals("Vibulaskja")) {
                karakter = new Vibulaskja(nimi);
            }
            return karakter;
        }
        public static Vaenlane vaenlased(String raskusaste) { // valib suvalise vaenlase
            Vaenlane vaenlane1 = null;
            if (raskusaste.equals("Kerge")) {
                Vaenlane nahkhiir = new Nahkhiir("nahkhiir");
                Vaenlane rott = new Rott("rott");
                Vaenlane vihmauss = new Vihmauss("vihmauss");
                Vaenlane kiirerott = new Rott("kiire rott");
                Random random = new Random();
                int suvaline = random.nextInt(0,7);
                if (suvaline == 0 || suvaline == 1){
                    vaenlane1 = nahkhiir;
                } else if (suvaline == 2 || suvaline == 3) {
                    vaenlane1 = rott;
                } else if (suvaline == 4 || suvaline == 5){
                    vaenlane1 = vihmauss;
                } else if (suvaline == 6) {
                    vaenlane1 = kiirerott;
                }
            } else if (raskusaste.equals("Raske")) {
                Vaenlane raisakotkas = new Raisakotkas("raisakotkas");
                Vaenlane hunt = new Hunt("hunt");
                Vaenlane draakon = new Draakon("draakon");
                Random random = new Random();
                int suvaline = random.nextInt(0,3);
                if (suvaline == 0) {
                    vaenlane1 = raisakotkas;
                } else if (suvaline == 1) {
                    vaenlane1 = hunt;
                } else {
                    vaenlane1 = draakon;
                }
            }
            System.out.println("Vaenlaseks osutus " + vaenlane1.getNimi());
            return vaenlane1;
        }
        public static int skoorisysteem(Vaenlane vaenlane) { // liidab skoori
            int skoor = 0;
            switch (vaenlane.getNimi()) {
                case "rott" -> skoor += 100;
                case "nahkhiir" -> skoor += 120;
                case "vihmauss" -> skoor += 140;
                case "raisakotkas" -> skoor += 200;
                case "hunt" -> skoor += 240;
                case "draakon" -> skoor += 280;
            }
            return skoor;
        }
}

