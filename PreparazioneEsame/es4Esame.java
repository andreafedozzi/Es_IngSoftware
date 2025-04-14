import java.util.*;

public class es4Esame {
    public static void main(String[] args) {
        Parcheggio p = new Parcheggio();
        p.aggiungiVeicolo(new Moto("AA123"));
        p.aggiungiVeicolo(new Auto("BB000ZZ"));
        p.aggiungiVeicolo(new Auto("CC999VV"));

        System.out.println("Veicoli presenti: ");
        List<Veicolo> listaVeicoli = p.listaVeicoliPresenti();
        for(Veicolo v : listaVeicoli){
            System.out.println(v.toString());
        }
        System.out.println("Tariffa totale: " + p.calcolaTariffaTotale());
        
        p.rimuoviVeicolo("AA123");

        System.out.println("Veicoli presenti: ");
        listaVeicoli = p.listaVeicoliPresenti();
        for(Veicolo v : listaVeicoli){
            System.out.println(v.toString());
        }
        System.out.println("Tariffa totale: " + p.calcolaTariffaTotale());
    }
}

abstract class Veicolo{
    private String targa;
    
    public Veicolo(String targa){
        this.targa = targa;
    }

    public String getTarga(){
        return this.targa;
    }

    public abstract double calcolaTariffa();

}

class Auto extends Veicolo{

    public Auto(String targa){
        super(targa);
    }

    public double calcolaTariffa(){
        return 7.50;
    }

    public String toString(){
        return "Auto: " + this.getTarga();
    }
}

class Moto extends Veicolo{

    public Moto(String targa){
        super(targa);
    }

    public double calcolaTariffa(){
        return 6.50;
    }

    public String toString(){
        return "Moto: " + this.getTarga();
    }

}

interface Parcheggiabile{
    void entra();
    void esci();
}

class Parcheggio implements Parcheggiabile{
    private List<Veicolo> listaVeicoli;

    public Parcheggio(){
        listaVeicoli = new ArrayList<>();
    }

    public void entra(){
        System.out.println("Entra");
    }
    public void esci(){
        System.out.println("Esci");
    }

    public void aggiungiVeicolo(Veicolo v){
        listaVeicoli.add(v);
    }

    public void rimuoviVeicolo(String targa){
        Iterator<Veicolo> iteratore = listaVeicoli.iterator();
        while(iteratore.hasNext()){
            Veicolo v = iteratore.next();
            if(v.getTarga().equals(targa)){
                iteratore.remove();
                System.out.println("Veicolo con targa " + v.getTarga() + " rimosso!");
            } 
        }
        
    }

    public double calcolaTariffaTotale(){
        double tariffa = 0;
        for(Veicolo v : listaVeicoli){
            tariffa += v.calcolaTariffa();
        }
        return tariffa;
    }

    public List<Veicolo> listaVeicoliPresenti(){
        return this.listaVeicoli;
    }
}
