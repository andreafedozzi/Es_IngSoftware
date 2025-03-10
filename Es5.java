package Esercizi1;
import java.util.*;

public class Es5{
    public static void main(String args[]){

        SistemaPrenotazioni sp = new SistemaPrenotazioni();

        Viaggio v1 = new ViaggioAereo("Londra", 100, "Ryanair");
        Viaggio v2 = new ViaggioAereo("Lisbona", 80, "Tap Portugal");
        Viaggio v3 = new ViaggioTreno("Roma", 50, 180);
        Viaggio v4 = new ViaggioTreno("Milano", 60, 74);

        sp.aggiungiViaggio(v1);
        sp.aggiungiViaggio(v2);
        sp.aggiungiViaggio(v3);
        sp.aggiungiViaggio(v4);

        sp.mostraViaggi();

        v1.prenota();
        v4.prenota();
        v1.prenota(); //Viaggio già prenotato

    }
}

interface Prenotabile{

    public void prenota();

}

abstract class Viaggio implements Prenotabile{

    protected String destinazione;
    protected int prezzo;
    protected boolean prenotato = false;

    public Viaggio(String destinazione, int prezzo){
        this.destinazione = destinazione;
        this.prezzo = prezzo;
    }

    public String descrizione(){
        return "Destinazione: " + this.destinazione + ", Prezzo: " + this.prezzo;
    }

    @Override
    public void prenota(){
        if(prenotato == false){
            prenotato = true;
            System.out.println("Prenotazione effettuata per: " + this.destinazione);
        }
        else{
            System.out.println("Questo viaggio è già stato prenotato!");
        }
    }

}

class ViaggioAereo extends Viaggio{

    private String compagnia;

    public ViaggioAereo(String destinazione, int prezzo, String compagnia){
        super(destinazione,prezzo);
        this.compagnia = compagnia;
    }

   @Override
   public String descrizione(){
        return super.descrizione() + ", Compagnia Aerea: " + this.compagnia;
   } 

}

class ViaggioTreno extends Viaggio{

    private int numeroPosto;

    public ViaggioTreno(String destinazione, int prezzo, int numeroPosto){
        super(destinazione,prezzo);
        this.numeroPosto = numeroPosto;
    }

    @Override
    public String descrizione(){
        return super.descrizione() + ", numeroPosto: " + this.numeroPosto;
    }

}

class SistemaPrenotazioni{

    ArrayList<Viaggio> viaggi = new ArrayList<>();

    public void aggiungiViaggio(Viaggio v){
        viaggi.add(v);
    }

    public void mostraViaggi(){
        System.out.println("\nViaggi disponibili: ");
        for(int i=0; i < viaggi.size(); i++){
            System.out.println(viaggi.get(i).descrizione());
        }
    }

}