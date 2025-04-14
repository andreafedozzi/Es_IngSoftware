import java.util.*;

public class esEsamePalestra {
    public static void main(String[] args) {
        Palestra p = new Palestra();

        Cliente c1 = new Cliente("Andrea","andrea@gmail.com","220425");
        Cliente c2 = new Cliente("Paolo","paolo@gmail.com","230726");

        Istruttore i1 = new Istruttore("Gino", "gino@gmail.com");
        Istruttore i2 = new Istruttore("Piero", "piero@gmail.com");

        Esercizio e1 = new Esercizio("Flessioni", "...", 10);
        Esercizio e2 = new Esercizio("Addominali", "...", 5);

        p.addCliente(c1);
        p.addCliente(c2);
        p.addIstruttore(i1);
        p.addIstruttore(i2);
        p.addEsercizio(e1);
        p.addEsercizio(e2);

        i1.assegnaEsercizio(c1, e1);
        i2.assegnaEsercizio(c2, e2);
        p.visualizzaEsercizi(c1);
        p.visualizzaEsercizi(c2);

        p.removeCliente(c2);
        p.removeIstruttore(i2);
        p.removeEsercizio(e2);
    }
}

abstract class Persona{
    protected String nome, email;

    public Persona(String nome, String email){
        this.nome = nome;
        this.email = email;
    }
}

class Cliente extends Persona{
    private boolean abbonamentoAttivo;
    private String dataScadenza;
    private List<Esercizio> eserciziAssegnati;

    public Cliente(String nome, String email, String dataScadenza){
        super(nome,email);
        this.abbonamentoAttivo = true;
        this.dataScadenza = dataScadenza;
        eserciziAssegnati = new ArrayList<>();
    }

    public void addEsercizio(Esercizio e){
        if(this.abbonamentoAttivo == true)
            eserciziAssegnati.add(e);
    }

    public void visualizzaEsAss(){
        for(Esercizio e : eserciziAssegnati){
            System.out.println(e.toString());
        }
    }

    public void setStatoAbbonamento(boolean b){
        abbonamentoAttivo = b;
    }
}

class Esercizio{
    private String nomeEsercizio, descrizione;
    private int durata;

    public Esercizio(String n, String d, int dur){
        this.nomeEsercizio = n;
        this.descrizione = d;
        this.durata = dur;
    }

    public String toString(){
        return this.nomeEsercizio + " " + this.descrizione + " " + this.durata;
    }
}

class Istruttore extends Persona{
    
    public Istruttore(String nome, String email){
        super(nome,email);
    }

    public void assegnaEsercizio(Cliente c, Esercizio e){
        c.addEsercizio(e);
    }

}

class Palestra{
    private List<Cliente> clienti;
    private List<Istruttore> istruttori;
    private List<Esercizio> esercizi;

    public Palestra(){
        clienti = new ArrayList<>();
        istruttori = new ArrayList<>();
        esercizi = new ArrayList<>();
    }

    public void visualizzaEsercizi(Cliente c){
        c.visualizzaEsAss();
    }

    public void addCliente(Cliente c){
        clienti.add(c);
    }
    public void removeCliente(Cliente c){
        clienti.remove(c);
    }
    public void addIstruttore(Istruttore i){
        istruttori.add(i);
    }
    public void removeIstruttore(Istruttore i){
        clienti.remove(i);
    }
    public void addEsercizio(Esercizio e){
        esercizi.add(e);
    }
    public void removeEsercizio(Esercizio e){
        esercizi.remove(e);
    }

}