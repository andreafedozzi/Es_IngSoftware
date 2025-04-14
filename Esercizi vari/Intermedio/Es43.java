import java.util.*;

public class Es43 {
    public static void main(String[] args){
        Rubrica rubrica = new Rubrica();
        Contatto c1 = new Contatto("Andrea", "12345", "andrea@gmail.com");
        Contatto c2 = new Contatto("Paolo", "67890", "paolo@gmail.com");

        rubrica.aggiungiContatto(c1);
        rubrica.aggiungiContatto(c2);

        rubrica.ricercaContatto("Andrea");
        rubrica.rimuoviContatto("Paolo");
        rubrica.ricercaContatto("Paolo");
    }
}

class Contatto {
    private String nome;
    private String numero;
    private String email;

    public Contatto(String nome, String numero, String email){
        this.nome = nome;
        this.numero = numero;
        this.email = email;
    }

    public String getNome(){
        return nome;
    }

    public String toString(){
        return nome + " - " + numero + " - " + email;
    }
}

class Rubrica {
    private List<Contatto> contatti;

    public Rubrica(){
        contatti = new ArrayList<>();
    }

    public void aggiungiContatto(Contatto c){
        contatti.add(c);
    }

    public void rimuoviContatto(String nome){
        contatti.removeIf(c -> c.getNome().equals(nome));
    }

    public void ricercaContatto(String nome){
        for(Contatto c : contatti){
            if(c.getNome().equals(nome)){
                System.out.println(c.toString());
                return;
            }
        }
        System.out.println("Contatto non trovato");
    }
}