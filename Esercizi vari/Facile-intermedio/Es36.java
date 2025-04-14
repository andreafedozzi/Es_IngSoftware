import java.util.ArrayList;
import java.util.List;

public class Es36 {
    public static void main(String[] args) {
        Libreria libreria = new Libreria();

        libreria.aggiungiLibro(new Libro("Il Signore degli Anelli", "boh", "Fantasy", 1904));
        libreria.aggiungiLibro(new Libro("1984", "Orwell", "politica?", 1949));

        List<Libro> risultati = libreria.ricerca("Orwell", "politica?", 0);

        for (Libro libro : risultati) {
            System.out.println(libro.getTitolo() + " - " + libro.getAutore() + " - " + libro.getGenere() + " - " + libro.getAnno());
        }
    }
}

class Libro {
    private String titolo;
    private String autore;
    private String genere;
    private int anno;

    public Libro(String titolo, String autore, String genere, int anno) {
        this.titolo = titolo;
        this.autore = autore;
        this.genere = genere;
        this.anno = anno;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public String getGenere() {
        return genere;
    }

    public int getAnno() {
        return anno;
    }
}

class Libreria {
    private List<Libro> libri;

    public Libreria() {
        libri = new ArrayList<>();
    }

    public void aggiungiLibro(Libro libro) {
        libri.add(libro);
    }

    public List<Libro> ricerca(String autore, String genere, int anno) {
        List<Libro> risultati = new ArrayList<>();
        for (Libro libro : libri) {
            if ((autore == null || libro.getAutore().equals(autore)) &&
                (genere == null || libro.getGenere().equals(genere)) &&
                (anno == 0 || libro.getAnno() == anno)) {
                risultati.add(libro);
            }
        }
        return risultati;
    }
}