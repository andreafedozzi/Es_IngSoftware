package Esercizi1;
import java.util.*;

public class Es4{
    public static void main(String args[]){

        Azienda az = new Azienda();

        Impiegato i1 = new Impiegato("Rossi", 1200);
        Impiegato i2 = new Impiegato("Bianchi", 1300);
        Manager m1 = new Manager("Verdi", 2000);

        az.aggiungiDipendente(i1);
        az.aggiungiDipendente(i2);
        az.aggiungiDipendente(m1);
        az.visualizzaDipendenti();

        System.out.println("Totale stipendi: " + az.calcolaTotale());

    }
}

abstract class Dipendente{
    protected String nome;
    protected int stipendio;

    public Dipendente(String nome, int stipendio){
        this.nome = nome;
        this.stipendio = stipendio;
    }

    public abstract int calcolaStipendio();

    public String toString(){
        return "Nome: " + nome + ", Stipendio: " + stipendio;
    }

}

class Impiegato extends Dipendente{

    public Impiegato(String nome, int stipendio){
        super(nome,stipendio);
    }

    @Override
    public int calcolaStipendio(){
        return stipendio*12;
    }

}

class Manager extends Dipendente{

    public Manager(String nome, int stipendio){
        super(nome,stipendio);
    }

    @Override
    public int calcolaStipendio(){
        return stipendio*12 + (stipendio*12*15/100); //15% bonus
    }

}

class Azienda{

    List<Dipendente> dip = new ArrayList<>();

    public void aggiungiDipendente(Dipendente dipendente){
        dip.add(dipendente);
    }

    public void rimuoviDipendente(Dipendente dipendente){
        dip.remove(dipendente);
    }

    public void visualizzaDipendenti(){
        
        for(int i=0; i < dip.size(); i++){
            System.out.println(dip.get(i).toString());
        }

    }

    public int calcolaTotale(){
        int totale=0;

        for(int i=0; i < dip.size(); i++){
            totale += dip.get(i).calcolaStipendio();
        }
        
        return totale;
    }


}