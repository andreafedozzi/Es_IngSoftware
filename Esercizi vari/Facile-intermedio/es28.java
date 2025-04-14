import java.util.*;

public class es28 {
    public static void main(String[] args) {
        ArrayList<Prodotto> magazzino = new ArrayList<>();

        magazzino.add(new Alimentare("Pasta", 1.5, "24/05"));
        magazzino.add(new Elettronico("Smartphone", 759.99, "Apple"));
        magazzino.add(new Alimentare("Latte", 2.99, "23/04"));
        magazzino.add(new Elettronico("Televisore", 500, "Samsung"));

        System.out.println("Prodotti Alimentari:");
        for (Prodotto prodotto : magazzino) {
            if (prodotto instanceof Alimentare) {
                System.out.println(prodotto);
            }
        }

        System.out.println("Prodotti Elettronici:");
        for (Prodotto prodotto : magazzino) {
            if (prodotto instanceof Elettronico) {
                System.out.println(prodotto);
            }
        }
    }
}

class Prodotto {
    private String nome;
    private double prezzo;

    public Prodotto(String nome, double prezzo) {
        this.nome = nome;
        this.prezzo = prezzo;
    }

    public String getNome() {
        return nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Prezzo: " + prezzo;
    }
}

class Alimentare extends Prodotto {
    private String dataScadenza;

    public Alimentare(String nome, double prezzo, String dataScadenza) {
        super(nome, prezzo);
        this.dataScadenza = dataScadenza;
    }

    public String getDataScadenza() {
        return dataScadenza;
    }

    @Override
    public String toString() {
        return super.toString() + ", Data di Scadenza: " + dataScadenza;
    }
}

class Elettronico extends Prodotto {
    private String marca;

    public Elettronico(String nome, double prezzo, String marca) {
        super(nome, prezzo);
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    @Override
    public String toString() {
        return super.toString() + ", Marca: " + marca;
    }
}