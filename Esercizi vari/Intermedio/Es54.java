import java.util.*;

public class Es54 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Fattura> fatture = new ArrayList<>();

        while (true) {
            System.out.println("Scegli un'opzione: 1. Crea Fattura  2. Visualizza Fatture  3. Esci");
            int scelta = scanner.nextInt();
            scanner.nextLine(); // Consuma il newline

            if (scelta == 1) {
                System.out.println("Inserisci il nome del cliente:");
                String cliente = scanner.nextLine();

                Fattura fattura = new Fattura(cliente);
                while (true) {
                    System.out.println("Inserisci il nome del prodotto (o 'fine' per terminare):");
                    String nomeProdotto = scanner.nextLine();
                    if (nomeProdotto.equalsIgnoreCase("fine")) {
                        break;
                    }

                    System.out.println("Inserisci il prezzo del prodotto:");
                    double prezzo = scanner.nextDouble();
                    scanner.nextLine(); // Consuma il newline

                    System.out.println("Inserisci la quantità:");
                    int quantita = scanner.nextInt();
                    scanner.nextLine(); // Consuma il newline

                    fattura.aggiungiProdotto(new Prodotto(nomeProdotto, prezzo, quantita));
                }

                fattura.calcolaTotaleConIVA();
                fatture.add(fattura);
                System.out.println("Fattura creata con successo!");
            } else if (scelta == 2) {
                for (Fattura fattura : fatture) {
                    System.out.println(fattura);
                }
            } else if (scelta == 3) {
                System.out.println("Uscita dal sistema. Arrivederci!");
                break;
            } else {
                System.out.println("Scelta non valida. Riprova.");
            }
        }

        scanner.close();
    }
}

class Prodotto {
    private String nome;
    private double prezzo;
    private int quantita;

    public Prodotto(String nome, double prezzo, int quantita) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.quantita = quantita;
    }

    public double calcolaTotale() {
        return prezzo * quantita;
    }

    public String toString() {
        return nome + " - Prezzo: " + prezzo + "€, Quantità: " + quantita + ", Totale: " + calcolaTotale() + "€";
    }
}

class Fattura {
    private String cliente;
    private List<Prodotto> prodotti;
    private double totaleConIVA;

    private static final double IVA = 0.22; // 22% IVA

    public Fattura(String cliente) {
        this.cliente = cliente;
        this.prodotti = new ArrayList<>();
    }

    public void aggiungiProdotto(Prodotto prodotto) {
        prodotti.add(prodotto);
    }

    public void calcolaTotaleConIVA() {
        double totale = 0;
        for (Prodotto prodotto : prodotti) {
            totale += prodotto.calcolaTotale();
        }
        totaleConIVA = totale + (totale * IVA);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Fattura per: ").append(cliente).append("\n");
        sb.append("Prodotti:\n");
        for (Prodotto prodotto : prodotti) {
            sb.append("  ").append(prodotto).append("\n");
        }
        sb.append("Totale con IVA: ").append(String.format("%.2f", totaleConIVA)).append("€");
        return sb.toString();
    }
}