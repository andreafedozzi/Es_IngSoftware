import java.util.*;

public class Es42 {
    public static void main(String[] args){
        Libro libro = new Libro("1984");
        Rivista rivista = new Rivista("Focus");

        Biblioteca biblioteca = new Biblioteca();
        biblioteca.prestaMateriale(libro);
        biblioteca.prestaMateriale(rivista);
        biblioteca.restituisciMateriale(libro);
    }
}

abstract class MaterialeBibliotecario {
    protected String titolo;

    public MaterialeBibliotecario(String titolo){
        this.titolo = titolo;
    }

    public String getTitolo(){
        return titolo;
    }
}

interface Prestabile {
    void presta();
    void restituisci();
}

class Libro extends MaterialeBibliotecario implements Prestabile {
    public Libro(String titolo){
        super(titolo);
    }

    public void presta(){
        System.out.println("Prestato il libro: " + titolo);
    }

    public void restituisci(){
        System.out.println("Restituito il libro: " + titolo);
    }
}

class Rivista extends MaterialeBibliotecario implements Prestabile {
    public Rivista(String titolo){
        super(titolo);
    }

    public void presta(){
        System.out.println("Prestata la rivista: " + titolo);
    }

    public void restituisci(){
        System.out.println("Restituita la rivista: " + titolo);
    }
}

class Biblioteca {
    public void prestaMateriale(Prestabile materiale){
        materiale.presta();
    }

    public void restituisciMateriale(Prestabile materiale){
        materiale.restituisci();
    }
}