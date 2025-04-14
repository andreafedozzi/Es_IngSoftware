import java.util.*;

public class Es41 {
    public static void main(String[] args){
        Cliente c = new Cliente("Andrea");
        Prodotto p1 = new Prodotto("prod1", 1000.0);
        Prodotto p2 = new Prodotto("prod2", 500.0);

        c.aggiungiProdotto(p1);
        c.aggiungiProdotto(p2);

        c.visualizzaCarrello();
        System.out.println("Totale ordine: " + c.calcolaTotale());
    }
}

class Prodotto {
    private String nome;
    private double prezzo;

    public Prodotto(String nome, double prezzo){
        this.nome = nome;
        this.prezzo = prezzo;
    }

    public String getNome(){
        return nome;
    }

    public double getPrezzo(){
        return prezzo;
    }
}

class Ordine {
    private List<Prodotto> prodotti;

    public Ordine(){
        prodotti = new ArrayList<>();
    }

    public void aggiungiProdotto(Prodotto p){
        prodotti.add(p);
    }

    public List<Prodotto> getProdotti(){
        return prodotti;
    }

    public double calcolaTotale(){
        double totale = 0;
        for(Prodotto p : prodotti){
            totale += p.getPrezzo();
        }
        return totale;
    }
}

class Cliente {
    private String nome;
    private Ordine ordine;

    public Cliente(String nome){
        this.nome = nome;
        this.ordine = new Ordine();
    }

    public void aggiungiProdotto(Prodotto p){
        ordine.aggiungiProdotto(p);
    }

    public void visualizzaCarrello(){
        for(Prodotto p : ordine.getProdotti()){
            System.out.println(p.getNome() + " - " + p.getPrezzo());
        }
    }

    public double calcolaTotale(){
        return ordine.calcolaTotale();
    }
}