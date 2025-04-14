import java.util.*;

public class GestioneOrdini {
    public static void main(String[] args) {
        List<Spedibile> ordini = new ArrayList<>();

        OrdineOnline ordine1 = new OrdineOnline("123", "Consegna");
        OrdineNegozio ordine2 = new OrdineNegozio("456", "Ritiro");

        ordini.add(ordine1);
        ordini.add(ordine2);

        for (Spedibile ordine : ordini) {
            System.out.println("Ordine ID: " + ordine.getId() + " - Metodo di spedizione: " + ordine.spedizione());
        }
    }
}

interface Spedibile {
    String spedizione();
    String getId();
}

class OrdineOnline implements Spedibile {
    private String idOrdine;
    private String metodoSpedizione;

    public OrdineOnline(String id, String metodo) {
        this.idOrdine = id;
        this.metodoSpedizione = metodo;
    }

    public String spedizione() {
        return this.metodoSpedizione;
    }

    public String getId() {
        return this.idOrdine;
    }
}

class OrdineNegozio implements Spedibile {
    private String idOrdine;
    private String metodoSpedizione;

    public OrdineNegozio(String id, String metodo) {
        this.idOrdine = id;
        this.metodoSpedizione = metodo;
    }

    public String spedizione() {
        return this.metodoSpedizione;
    }

    public String getId() {
        return this.idOrdine;
    }
}