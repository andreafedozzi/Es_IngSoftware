import java.util.*;

public class esEsameMagazzino {
    public static void main(String[] args) {
        Prodotto p1 = new Prodotto("abc", "Pere", 100, 500);
        Prodotto p2 = new Prodotto("def","Mele",50,2);

        Magazzino m = new Magazzino(100,0);
        m.aggiungiProdotto(p1);
        m.aggiungiProdotto(p2);
        m.visualizzaLog();

        m.rimuoviProdotto(p1);
        m.rimuoviProdotto(p2);
        m.visualizzaLog();

        m = new MagazzinoAvanzato(100, 0);
        m.aggiungiProdotto(p1);
        m.aggiungiProdotto(p2);
        m.visualizzaLog();
        m.rimuoviProdotto(p1);
        m.rimuoviProdotto(p2);
        m.visualizzaLog();


    }
}

interface Magazzinabile{
    public abstract int calcolaSpazio();
    public abstract String getInfo();
}

class Prodotto implements Magazzinabile{
    private String idProdotto, nome;
    private int quantita, dimUnitaria;

    public Prodotto(String idProdotto, String nome, int quantita, int dimUnitaria){
        this.idProdotto = idProdotto;
        this.nome = nome;
        this.quantita = quantita;
        this.dimUnitaria =  dimUnitaria;
    }

    public String getInfo(){
        return this.idProdotto + " " + this.nome + " " + this.quantita + " " + this.dimUnitaria;
    }

    public int calcolaSpazio(){
        return this.quantita*this.dimUnitaria;
    }

    public String getId(){
        return this.idProdotto;
    }

    public String getNome(){
        return this.nome;
    }

    public int getQta(){
        return this.quantita;
    }

    public int getDimUnitaria(){
        return this.dimUnitaria;
    }

    public void setNull(){
        this.idProdotto = null;
        this.nome = null;
        this.quantita = 0;
        this.dimUnitaria = 0;
    }


}

class Magazzino{
    protected int capacitaMassima, spazioOccupato;
    protected Prodotto[] prodotti;

    public Magazzino(int cap, int spaz){
        this.capacitaMassima = cap;
        this.spazioOccupato = spaz;
        prodotti = new Prodotto[capacitaMassima];
    }

    public void aggiungiProdotto(Prodotto p) {
        if (spazioOccupato < prodotti.length) {
            prodotti[spazioOccupato] = new Prodotto(p.getId(), p.getNome(), p.getQta(), p.getDimUnitaria());
            spazioOccupato++;
        } else {
            System.out.println("Array pieno!");
        }
    }

    public void rimuoviProdotto(Prodotto p) {
        for (int i = 0; i < spazioOccupato; i++) {
            if (prodotti[i].getId().equals(p.getId())) {
                // Sposto indietro tutti gli elementi successivi
                for (int j = i; j < spazioOccupato - 1; j++) {
                    prodotti[j] = prodotti[j + 1];
                }
                prodotti[spazioOccupato - 1] = null; // Libero l'ultimo slot
                spazioOccupato--; // Diminuisco il numero effettivo di prodotti
                break; // Rimuovi solo il primo match
            }
        }
    }

    public void visualizzaLog(){
        System.out.println("Prodotti inseriti: ");
        if (spazioOccupato == 0) {
            System.out.println("Nessun prodotto presente.");
        }
        for(int i = 0; i<spazioOccupato; i++){
            System.out.println(prodotti[i].getInfo());
        }
    }

}

class MagazzinoAvanzato extends Magazzino{
    private ArrayList<String> logTransazioni;

    public MagazzinoAvanzato(int cap, int spaz){
        super(cap,spaz);
        logTransazioni = new ArrayList<>();
    }

    
    public void aggiungiProdotto(Prodotto p){
        super.aggiungiProdotto(p);
        logTransazioni.add(p.getInfo());

    }

    public void rimuoviProdotto(Prodotto p){
        super.rimuoviProdotto(p);
        logTransazioni.remove(p.getInfo());
    }

    @Override
    public void visualizzaLog(){
        System.out.println("Prodotti inseriti: ");
        for(String s : logTransazioni){
            System.out.println(s);
        }
    }
}