import java.util.*;
import java.util.function.Predicate;

public class es24 {
    public static void main(String[] args) {
        Catalogo<Prodotto> catalogo = new Catalogo<>();

        catalogo.aggiungi(new Prodotto("prodotto1", 470, true));
        catalogo.aggiungi(new Prodotto("prodotto2", 69.59, true));
        catalogo.aggiungi(new Prodotto("boh", 1200.50, false));

        System.out.println("Prodotti con prezzo inferiore a 800:");
        List<Prodotto> filtratiPerPrezzo = catalogo.filtra(p -> p.getPrezzo() < 800);
        for (Prodotto p : filtratiPerPrezzo) {
            System.out.println(p);
        }

        System.out.println("\nProdotti disponibili:");
        List<Prodotto> filtratiPerDisponibilita = catalogo.filtra(Prodotto::isDisponibile);
        for (Prodotto p : filtratiPerDisponibilita) {
            System.out.println(p);
        }

        System.out.println("\nProdotti con nome contenente 'Smart':");
        List<Prodotto> filtratiPerNome = catalogo.filtra(p -> p.getNome().contains("Smart"));
        for (Prodotto p : filtratiPerNome) {
            System.out.println(p);
        }
    }
}

class Prodotto {
    private String nome;
    private double prezzo;
    private boolean disponibile;

    public Prodotto(String nome, double prezzo, boolean disponibile) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.disponibile = disponibile;
    }

    public String getNome() {
        return nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public boolean isDisponibile() {
        return disponibile;
    }

    @Override
    public String toString() {
        return "Prodotto{" +
               "nome='" + nome + '\'' +
               ", prezzo=" + prezzo +
               ", disponibile=" + disponibile +
               '}';
    }
}

class Catalogo<T> {
    private List<T> prodotti = new ArrayList<>();

    public void aggiungi(T prodotto) {
        prodotti.add(prodotto);
    }

    public List<T> filtra(Predicate<T> criterio) {
        List<T> risultati = new ArrayList<>();
        for (T prodotto : prodotti) {
            if (criterio.test(prodotto)) {
                risultati.add(prodotto);
            }
        }
        return risultati;
    }
}