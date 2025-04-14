public class esEsame1 {
    public static void main(String[] args) {
        Manager m = new Manager("Andrea", 123);
        Sviluppatore s = new Sviluppatore("Gianni", 456);
        
        m.lavora();
        System.out.println("Stipendio manager: " + m.calcolaPaga());
        s.lavora();
        System.out.println("Stipendio sviluppatore: " + s.calcolaPaga());
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

    public Dipendente(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }
}

class Manager extends Dipendente{
    private int mobile;

    public Manager(String nome, int mobile){
        super(nome);
        this.mobile = mobile;
    }

    @Override
    public void lavora(){
        System.out.println("Lavora: " + super.getNome() + ", " + this.mobile);
    }
    @Override
    public double calcolaPaga(){
        return 2.5;
    }
}

class Sviluppatore extends Dipendente{
    private int matricola;

    public Sviluppatore(String nome, int matricola){
        super(nome);
        this.matricola = matricola;
    }
    
    @Override
    public void lavora(){
        System.out.println("Lavora: " + super.getNome() + ", " + this.matricola);
    }
    @Override
    public double calcolaPaga(){
        return 1.5;
    }
}

