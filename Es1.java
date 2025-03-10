package Esercizi1;
public class Es1{
    public static void main(String[] args){
        
        Auto[] a = new Auto[10];
        Moto[] m = new Moto[10];

        a[0] = new Auto("AB123CD");
        System.out.println(a[0].getTarga());
        a[0].avvia();
        a[0].ferma();
        System.out.println("Tipo: " + a[0].getTipo() + "\n");

        m[0] = new Moto("AA123AA");
        System.out.println(m[0].getTarga());
        m[0].avvia();
        m[0].ferma();
        System.out.println("Tipo: " + m[0].getTipo() + "\n");
    }
}

interface Veicolo{
    public int avvia();
    public int ferma();
    public String getTipo();
}

abstract class MezzoDiTrasporto implements Veicolo{
    
    protected String targa;

    public MezzoDiTrasporto(String trg){
        this.targa = trg;
    }

    public String getTarga(){
        return targa;
    }

}

class Auto extends MezzoDiTrasporto{

    private String tipo = "auto";

    public Auto(String targa){
        super(targa);
    }

    @Override
    public int avvia(){
        System.out.println("Accesa!");
        return 1;
    }

    @Override
    public int ferma(){
        System.out.println("Spenta!");
        return 0;
    }

    @Override
    public String getTipo(){
        return tipo;
    }

}

class Moto extends MezzoDiTrasporto{

    private String tipo = "moto";

    public Moto(String targa){
        super(targa);
    }

    @Override
    public int avvia(){
        System.out.println("Accesa!");
        return 1;
    }

    @Override
    public int ferma(){
        System.out.println("Spenta!");
        return 0;
    }

    @Override
    public String getTipo(){
        return tipo;
    }

}