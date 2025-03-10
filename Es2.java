package Esercizi1;
import java.util.*;

public class Es2{
    public static void main(String args[]){

            Biblioteca b = new Biblioteca();

            Libro l1 = new Libro("1984", 1949, "George Orwell");
            Rivista r1 = new Rivista("Focus", 2024, 100);

            b.aggiungiMateriale(l1);
            b.aggiungiMateriale(r1);

            b.visualizzaMateriale();

            b.rimuoviMateriale(r1);
            b.visualizzaMateriale();

    }
}

abstract class MaterialeBibliotecario{
    protected String titolo;
    protected int annoPubblicazione;

    public MaterialeBibliotecario(String titolo, int annoPubblicazione){
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
    }

    public String toString(){
        return "Titolo: " + titolo + ", Anno: " + annoPubblicazione;
    }

}

class Libro extends MaterialeBibliotecario{
    private String autore;

    public Libro(String titolo, int annoPubblicazione, String autore){
        super(titolo, annoPubblicazione);
        this.autore = autore;
    }

     @Override
    public String toString(){
        return super.toString() + ", Autore: " + autore;
    }

}

class Rivista extends MaterialeBibliotecario{
    private int nEdizione;

    public Rivista(String titolo, int annoPubblicazione, int nEdizione){
        super(titolo, annoPubblicazione);
        this.nEdizione = nEdizione;
    }

    @Override
    public String toString(){
        return super.toString() + ", Numero Edizione: " + nEdizione;
    }

}

class Biblioteca{

    List<MaterialeBibliotecario> materiali = new ArrayList<>();

    public void aggiungiMateriale(MaterialeBibliotecario mat){
        materiali.add(mat);
    }

    public void rimuoviMateriale(MaterialeBibliotecario mat){
        materiali.remove(mat);
    }

    public void visualizzaMateriale(){
        int i=0;

        for(i=0; i<materiali.size(); i++){
            System.out.println(materiali.get(i).toString());
        }

    }
}
