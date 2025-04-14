import java.util.*;

public class esEsameParcoDiverimenti {
    public static void main(String[] args) {
        
    }
}

abstract class Persona{
    protected int id, eta;
    protected String nome;

    public Persona(int id, int eta, String nome){
        this.id = id;
        this.eta = eta;
        this.nome = nome;
    }

    public int getId(){
        return id;
    }
    public int getEta(){
        return eta;
    }
    public String getNome(){
        return nome;
    }
}

class Visitatore extends Persona{
    private List<Biglietto> bigliettiVisitatore;

    public Visitatore(int id, String nome, int eta){
        super(id,eta,nome);
    }

    public void acquistaBiglietto(Biglietto b){
        bigliettiVisitatore.add(b);
    }

    public void visualizzaBiglietti(){
        for(Biglietto b : bigliettiVisitatore){
            System.out.println(b.toString());
        }
    }

    public String getNome(){
        return nome;
    }

    public String toString(){
        return this.nome + " " + this.eta + " " + this.id;
    }
}

class Biglietto{
    private int idBiglietto;
    private Attrazione attrazione;
    private String stato;

    public Biglietto(int id, Attrazione a, String s){
        this.idBiglietto = id;
        this.attrazione = a;
        this.stato = s;
    }

    public void aggiornaStato(String stato){
        this.stato = stato;
    }

    public String toString(){
        return this.idBiglietto + " " + this.attrazione.getNome() + " " + this.stato;
    }

}

class Attrazione{
    private int idAttrazione, livelloPericolo;
    private String nome;
    private Personale personaleAssegnato;

    public Attrazione(int idAttrazione, String nome, int livelloPericolo){
        this.idAttrazione = idAttrazione;
        this.nome = nome;
        this.livelloPericolo = livelloPericolo;
    }

    public String toString(){
        return this.idAttrazione + " " + this.nome + " " + livelloPericolo;
    }

    public String getNome(){
        return this.nome;
    }

    public void assegnaPersonale(Personale p){
        this.personaleAssegnato = p;
    }

    public boolean isOperativi(){
        return !false;
    }
}

class Personale extends Persona{
    private String specializzazione;
    private List<Attrazione> attrazioniGestite;

    public Personale(int id, String nome, int eta, String specializzazione, Attrazione attrazione){
        super(id,eta,nome);
        this.specializzazione = specializzazione;
        this.attrazioniGestite = new ArrayList<>();
    }

    public void aggiungiAttrazione(Attrazione a){
        attrazioniGestite.add(a);
    }
    public void visualizzaAttrazioni(){
        System.out.println("Attrazioni gestite: ");
        for(Attrazione a : attrazioniGestite){
            System.out.println(a.toString());
        }
    }

}

class ParcoDivertimenti{
    private List<Visitatore> visitatori;
    private List<Personale> personale;
    private List<Attrazione> attrazioni;

    private List<Visitatore> vistatori_found;
    private List<Personale> personale_found;

    public ParcoDivertimenti(){
        visitatori = new ArrayList<>();
        personale = new ArrayList<>();
        attrazioni = new ArrayList<>();
    }

    public void aggiungiAttrazione(Attrazione a){
        attrazioni.add(a);
    }
    public void aggiungiPersonale(Personale p){
        personale.add(p);
    }
    public void aggiungiVisitatore(Visitatore v){
        visitatori.add(v);
    }

    public void cercaVisitatoriPerNome(String nome){
        for(Visitatore v : visitatori){
            if(v.getNome().equals(nome))
                vistatori_found.add(v);
        }
        System.out.println("Visitatori trovati: ");
        for(Visitatore v : vistatori_found){
            System.out.println(v.toString());
        }
    }

}