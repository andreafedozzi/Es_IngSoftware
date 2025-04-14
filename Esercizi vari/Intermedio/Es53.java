import java.util.Scanner;

public class Es53 {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca(10); 
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Scegliere un'opzione: 1. Aggiungi libro  2. Cerca libro  3. Esci");
            int scelta = scanner.nextInt();
            scanner.nextLine(); 

            if (scelta == 1) {
                System.out.println("Inserisci il titolo del libro:");
                String titolo = scanner.nextLine();
                System.out.println("Inserisci l'autore del libro:");
                String autore = scanner.nextLine();
                System.out.println("Inserisci l'ISBN del libro:");
                String isbn = scanner.nextLine();

                if (biblioteca.aggiungiLibro(new Libro(titolo, autore, isbn))) {
                    System.out.println("Libro aggiunto con successo!");
                } else {
                    System.out.println("Biblioteca piena! Impossibile aggiungere altri libri.");
                }
            } else if (scelta == 2) {
                System.out.println("Cerca per: 1. Titolo  2. Autore");
                int criterio = scanner.nextInt();
                scanner.nextLine(); 

                if (criterio == 1) {
                    System.out.println("Inserisci il titolo da cercare:");
                    String titolo = scanner.nextLine();
                    biblioteca.cercaPerTitolo(titolo);
                } else if (criterio == 2) {
                    System.out.println("Inserisci l'autore da cercare:");
                    String autore = scanner.nextLine();
                    biblioteca.cercaPerAutore(autore);
                } else {
                    System.out.println("Criterio non valido.");
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

class Libro {
    private String titolo;
    private String autore;
    private String isbn;

    public Libro(String titolo, String autore, String isbn) {
        this.titolo = titolo;
        this.autore = autore;
        this.isbn = isbn;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public String toString() {
        return "Titolo: " + titolo + ", Autore: " + autore + ", ISBN: " + isbn;
    }
}

class Biblioteca {
    private Libro[] libri;
    private int indice;

    public Biblioteca(int capacita) {
        libri = new Libro[capacita];
        indice = 0;
    }

    public boolean aggiungiLibro(Libro libro) {
        if (indice < libri.length) {
            libri[indice] = libro;
            indice++;
            return true;
        }
        return false;
    }

    public void cercaPerTitolo(String titolo) {
        boolean trovato = false;
        for (Libro libro : libri) {
            if (libro != null && libro.getTitolo().equalsIgnoreCase(titolo)) {
                System.out.println(libro);
                trovato = true;
            }
        }
        if (!trovato) {
            System.out.println("Nessun libro trovato con il titolo: " + titolo);
        }
    }

    public void cercaPerAutore(String autore) {
        boolean trovato = false;
        for (Libro libro : libri) {
            if (libro != null && libro.getAutore().equalsIgnoreCase(autore)) {
                System.out.println(libro);
                trovato = true;
            }
        }
        if (!trovato) {
            System.out.println("Nessun libro trovato con l'autore: " + autore);
        }
    }
}