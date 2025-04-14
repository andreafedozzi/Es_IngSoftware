import java.util.Random;

public class Es35 {
    public static void main(String[] args) {
        Giocatore g1 = new Giocatore("Giocatore 1");
        Giocatore g2 = new Giocatore("Giocatore 2");

        for (int turno = 1; turno <= 5; turno++) {
            System.out.println("Turno " + turno);
            g1.giocaTurno();
            g2.giocaTurno();
        }

        System.out.println(g1.getNome() + " - Punteggio Totale: " + g1.getPunteggio());
        System.out.println(g2.getNome() + " - Punteggio Totale: " + g2.getPunteggio());

        if (g1.getPunteggio() > g2.getPunteggio()) {
            System.out.println("Vince " + g1.getNome());
        } else if (g2.getPunteggio() > g1.getPunteggio()) {
            System.out.println("Vince " + g2.getNome());
        } else {
            System.out.println("Pareggio");
        }
    }
}

class Giocatore {
    private String nome;
    private int punteggio;
    private Random random;

    public Giocatore(String nome) {
        this.nome = nome;
        this.punteggio = 0;
        this.random = new Random();
    }

    public void giocaTurno() {
        int turnoPunti = 0;
        for (int i = 0; i < 3; i++) {
            turnoPunti += random.nextInt(6) + 1;
        }
        punteggio += turnoPunti;
        System.out.println(nome + " ha totalizzato " + turnoPunti + " punti in questo turno");
    }

    public String getNome() {
        return nome;
    }

    public int getPunteggio() {
        return punteggio;
    }
}