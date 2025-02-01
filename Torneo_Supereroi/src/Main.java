import java.util.Random;
import java.util.Scanner;

class Main {
    private static boolean[] supereroiScelti = new boolean[8]; // Array per tenere traccia dei supereroi scelti
    private static Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Benvenuti nel Torneo dei Supereroi!");
        System.out.println("Ogni giocatore sceglierà 4 supereroi per la battaglia.");
        Supereroe[] squadra1 = scegliSquadra(scanner, "Giocatore 1");
        Supereroe[] squadra2 = scegliSquadra(scanner, "Giocatore 2");
        System.out.println("\nInizia il Torneo!");

        int roundVintiGiocatore1 = 0; // Contatore round vinti dal Giocatore 1
        int roundVintiGiocatore2 = 0; // Contatore round vinti dal Giocatore 2

        for (int i = 0; i < 4; ++i) {
            Supereroe eroe1 = squadra1[i];
            Supereroe eroe2 = squadra2[i];
            System.out.println("\nDuello tra " + eroe1.nome + " e " + eroe2.nome + "!");
            boolean vintoGiocatore1 = combatti(scanner, eroe1, eroe2);

            if (vintoGiocatore1) {
                roundVintiGiocatore1++; // Incrementa i round vinti dal Giocatore 1
            } else {
                roundVintiGiocatore2++; // Incrementa i round vinti dal Giocatore 2
            }
        }

        // Dichiarazione del vincitore del torneo
        System.out.println("\nTorneo Terminato!");
        System.out.println("Giocatore 1 ha vinto " + roundVintiGiocatore1 + " round.");
        System.out.println("Giocatore 2 ha vinto " + roundVintiGiocatore2 + " round.");

        if (roundVintiGiocatore1 > roundVintiGiocatore2) {
            System.out.println("Il Giocatore 1 è il vincitore del torneo!");
        } else if (roundVintiGiocatore2 > roundVintiGiocatore1) {
            System.out.println("Il Giocatore 2 è il vincitore del torneo!");
        } else {
            System.out.println("Il torneo è finito in pareggio!");
        }
    }

    public static Supereroe[] scegliSquadra(Scanner scanner, String giocatore) {
        Supereroe[] squadra = new Supereroe[4];
        System.out.println(giocatore + ", scegli i tuoi supereroi:");

        for (int i = 0; i < 4; ++i) {
            squadra[i] = scegliSupereroe(scanner, i + 1);
        }

        return squadra;
    }

    public static Supereroe scegliSupereroe(Scanner scanner, int numero) {
        System.out.println("Supereroe #" + numero + ":");
        System.out.println("1. Astro\n2. Hulk\n3. Iron Man\n4. Spider-Man\n5. Batman\n6. Wonder Woman\n7. Flash\n8. Cat-Woman");
        int scelta = scanner.nextInt();

        if (scelta < 1 || scelta > 8) {
            System.out.println("Scelta non valida, riprova.");
            return scegliSupereroe(scanner, numero);
        }

        if (supereroiScelti[scelta - 1]) {
            System.out.println("Questo supereroe è già stato scelto. Scegli un altro supereroe.");
            return scegliSupereroe(scanner, numero);
        }

        supereroiScelti[scelta - 1] = true; // Segna il supereroe come scelto

        switch (scelta) {
            case 1:
                return new Astro();
            case 2:
                return new Hulk();
            case 3:
                return new IronMan();
            case 4:
                return new SpiderMan();
            case 5:
                return new Batman();
            case 6:
                return new WonderWoman();
            case 7:
                return new Flash();
            case 8:
                return new CatWoman();
            default:
                return null;
        }
    }

    public static boolean combatti(Scanner scanner, Supereroe eroe1, Supereroe eroe2) {
        while (eroe1.isAlive() && eroe2.isAlive()) {
            turno(scanner, eroe1, eroe2);
            if (eroe2.isAlive()) {
                turno(scanner, eroe2, eroe1);
            }

            // Intervento di Erebus
            interventoErebus(eroe1, eroe2);
        }

        if (eroe1.isAlive()) {
            System.out.println(eroe1.nome + " ha vinto il round!");
            return true; // Giocatore 1 vince il round
        } else {
            System.out.println(eroe2.nome + " ha vinto il round!");
            return false; // Giocatore 2 vince il round
        }
    }

    public static void interventoErebus(Supereroe eroe1, Supereroe eroe2) {
        String[] scenari = {"Big Ben", "Autobus", "London Eye", "Piccadilly Square"};
        String scenarioScelto = scenari[random.nextInt(scenari.length)];
        System.out.println("\nErebus, il malvagio, interviene! Scenario scelto: " + scenarioScelto);

        // Sceglie casualmente uno dei due supereroi
        Supereroe bersaglio = random.nextBoolean() ? eroe1 : eroe2;

        // Infligge un danno casuale tra 50 e 200
        int danno = 50 + random.nextInt(151); // 50 + (0-150) = 50-200
        bersaglio.energia -= danno;

        if (bersaglio.energia < 0) {
            bersaglio.energia = 0;
        }

        System.out.println("Erebus infligge " + danno + " danni a " + bersaglio.nome + "!");
        System.out.println(bersaglio.nome + " ora ha " + bersaglio.energia + " punti vita.");
    }

    public static void turno(Scanner scanner, Supereroe attaccante, Supereroe difensore) {
        if (!attaccante.isAlive()) {
            System.out.println(attaccante.nome + " non ha abbastanza energia per combattere!");
        } else {
            System.out.println("\n" + attaccante.nome + " (Energia: " + attaccante.energia + ")");
            System.out.println("1. Usa Potere 1\n2. Usa Potere 2");
            int scelta = scanner.nextInt();
            switch (scelta) {
                case 1 -> attaccante.usaPotere1(difensore);
                case 2 -> attaccante.usaPotere2(difensore);
                default -> System.out.println("Scelta non valida, turno perso.");
            }

            if (difensore.energia <= 0) {
                System.out.println(difensore.nome + " è stato sconfitto!");
            }
        }
    }
}