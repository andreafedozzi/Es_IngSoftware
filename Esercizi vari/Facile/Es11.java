import java.util.*;

public class Es11 {
    public static void main(String[] args) {
        List<Prodotto> prodotti = new ArrayList<>();

        prodotti.add(new Prodotto("prod1", "abcdef1", 34.40));
        prodotti.add(new Prodotto("prod2", "abcdef2", 19.99));
        Scanner sc = new Scanner(System.in);

        System.out.println("Inserisci codice prodotto da cercare: ");
        String cod = sc.nextLine();
        for(Prodotto p : prodotti){
            if(p.getCodice().equals(cod))
                System.out.println(p.toString());
        }
        sc.close();
    }
}

class Prodotto{
    private String nome, codice;
    private double prezzo;

    public Prodotto(String n, String c, double p){
        this.nome = n;
        this.codice = c;
        this.prezzo = p;
    }

    public String getCodice(){
        return this.codice;
    }

    public String toString(){
        return this.nome + " " + this.prezzo + " " + this.codice;
    }

}
