import java.util.*;

public class Es45 {
    public static void main(String[] args){
        Scuola scuola = new Scuola();
        Studente s1 = new Studente("Andrea", "mat1");
        Studente s2 = new Studente("Paolo", "mat2");
        Insegnante i1 = new Insegnante("Piero", "mat3");

        scuola.aggiungiPersona(s1);
        scuola.aggiungiPersona(s2);
        scuola.aggiungiPersona(i1);

        scuola.visualizzaPersone();
    }
}

abstract class Persona {
    protected String nome;

    public Persona(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public abstract String getDettagli();
}

class Studente extends Persona {
    private String corso;

    public Studente(String nome, String corso){
        super(nome);
        this.corso = corso;
    }

    public String getDettagli(){
        return "Studente: " + nome + ", Corso: " + corso;
    }
}

class Insegnante extends Persona {
    private String materia;

    public Insegnante(String nome, String materia){
        super(nome);
        this.materia = materia;
    }

    public String getDettagli(){
        return "Insegnante: " + nome + ", Materia: " + materia;
    }
}

class Scuola {
    private List<Persona> persone;

    public Scuola(){
        persone = new ArrayList<>();
    }

    public void aggiungiPersona(Persona p){
        persone.add(p);
    }

    public void visualizzaPersone(){
        for(Persona p : persone){
            System.out.println(p.getDettagli());
        }
    }
}