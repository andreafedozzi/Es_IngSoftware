public class Es33 {
    public static void main(String[] args) {
        Parcheggio parcheggio = new Parcheggio(5);

        Auto a1 = new Auto("AA111AA");
        Auto a2 = new Auto("BB222BB");
        Auto a3 = new Auto("CC333CC");

        parcheggio.entra(a1);
        parcheggio.entra(a2);
        parcheggio.entra(a3);

        parcheggio.stato();

        parcheggio.esci(a2);

        parcheggio.stato();
    }
}

class Auto {
    private String targa;

    public Auto(String targa) {
        this.targa = targa;
    }

    public String getTarga() {
        return targa;
    }
}

class PostoAuto {
    private Auto auto;

    public boolean occupa(Auto a) {
        if (auto == null) {
            auto = a;
            return true;
        }
        return false;
    }

    public boolean libera() {
        if (auto != null) {
            auto = null;
            return true;
        }
        return false;
    }

    public boolean occupato() {
        return auto != null;
    }

    public Auto getAuto() {
        return auto;
    }
}

class Parcheggio {
    private PostoAuto[] posti;

    public Parcheggio(int numeroPosti) {
        posti = new PostoAuto[numeroPosti];
        for (int i = 0; i < numeroPosti; i++) {
            posti[i] = new PostoAuto();
        }
    }

    public void entra(Auto a) {
        for (PostoAuto posto : posti) {
            if (posto.occupa(a)) {
                return;
            }
        }
    }

    public void esci(Auto a) {
        for (PostoAuto posto : posti) {
            if (posto.getAuto() != null && posto.getAuto().getTarga().equals(a.getTarga())) {
                posto.libera();
                return;
            }
        }
    }

    public void stato() {
        for (int i = 0; i < posti.length; i++) {
            System.out.println("Posto " + (i + 1) + ": " + (posti[i].occupato() ? posti[i].getAuto().getTarga() : "Libero"));
        }
    }
}