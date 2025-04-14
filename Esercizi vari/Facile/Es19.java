package Facile;

public class Es19 {
    public static void main(String[] args) {
        Abbonamento a = new Abbonamento(12, 25.50);
        Fattura f = new Fattura(12, 9);

        System.out.println("Totale abbonamenoto: " + a.calcolaTotale());
        System.out.println("Totale fattura: " + f.calcolaTotale());
    }
}

interface Pagabile{
    double calcolaTotale();
}

class Fattura implements Pagabile{

    private int ore;
    private double prezzoOrario;

    public Fattura(int ore, double prezzo){
        this.ore = ore;
        this.prezzoOrario = prezzo;
    }

    public double calcolaTotale(){
        return ore*prezzoOrario;
    }
}

class Abbonamento implements Pagabile{

    private int mensilita;
    private double prezzoMensile;

    public Abbonamento(int mensilita, double prezzoMensile){
        this.mensilita = mensilita;
        this.prezzoMensile = prezzoMensile;
    }

    public double calcolaTotale(){
        return mensilita*prezzoMensile;
    }
}