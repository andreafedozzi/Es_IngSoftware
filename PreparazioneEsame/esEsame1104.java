import java.util.*;

public class esEsame1104 {
    public static void main(String[] args) {
        Manager m = new Manager(348232);
        List<Dipendente> dipendenti = new ArrayList<>();
        for(int i = 0; i<10; i++){
            dipendenti.add(new Sviluppatore(i));
        }
        dipendenti.add(m);

        for (Dipendente d : dipendenti) {
            d.lavora();
            System.out.println(" " + d.calcolaPaga());
        }

    }
}

interface Lavoratore{
    public void lavora();
}

interface Pagabile{
    public double calcolaPaga();
}

abstract class Dipendente implements Lavoratore,Pagabile{

    private String nome;

    public String getName(){
        return this.nome;
    }

}

class Manager extends Dipendente{
    private int mobile;

    public Manager(int mobile){
        this.mobile = mobile;
    }

    public void lavora(){
        System.out.println("Lavora!");
    }
    public double calcolaPaga(){
        return 2.5;
    }

}

class Sviluppatore extends Dipendente{
    private int matricola;

    public Sviluppatore(int matricola){
        this.matricola = matricola;
    }

    public void lavora(){
        System.out.println("Lavora sviluppatore");
    }
    public double calcolaPaga(){
        return 1.5;
    }
}

