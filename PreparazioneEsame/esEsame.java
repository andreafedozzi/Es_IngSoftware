import java.util.*;

public class esEsame {
    public static void main(String args[]){
        
        Biblioteca biblioteca = new Biblioteca();
        Libro l1 = new Libro("Il signore degli anelli");
        Libro l2 = new Libro("1984");

        Utente u1 = new Utente("Andrea","andrea@prova");
        Utente u2 = new Utente("Paolo","paolo@prova");

        StaffBiblioteca staff = new StaffBiblioteca("Staff", "staff@prova");
        staff.addLibro(l1, biblioteca);
        staff.addLibro(l2, biblioteca);

        biblioteca.addPrenotazione(u2, l2);
        biblioteca.addPrenotazione(u1, l1);

        biblioteca.removePrenotazione(u1, l1);

    }
}

abstract class Persona{
    protected String nome, email;

    public Persona(String n, String e){
        this.nome = n;
        this.email = e;
    }

}

class Utente extends Persona{

    public Utente(String n, String e){
        super(n,e);
    }

    public String getNome(){
        return this.nome;
    }

}

class StaffBiblioteca extends Persona{

    public StaffBiblioteca(String n, String e){
        super(n,e);
    }

    public void addLibro(Libro l, Biblioteca bib){
        bib.addLibro(l);
    }

    public void removeLibro(Libro l, Biblioteca bib){
        bib.removeLibro(l);
    }

}

class Biblioteca{

    private List<Prenotazione> prenotazioni;
    private List<Libro> libri;

    public Biblioteca(){
        prenotazioni = new ArrayList<>();
        libri = new ArrayList<>();
    }

    public void addLibro(Libro l){
        libri.add(l);
    }
    public void removeLibro(Libro l){
        libri.remove(l);
    }
    public void addPrenotazione(Utente u, Libro l){
        
        if(l.isDisponibile()==true){
            prenotazioni.add(new Prenotazione(u,l));
        }
        l.setDisponibile(false);

    }
    public void removePrenotazione(Utente u, Libro l){
        Iterator<Prenotazione> it = prenotazioni.iterator();
        while (it.hasNext()) {
            Prenotazione p = it.next();
            if (p.equals(new Prenotazione(u, l))) {
                it.remove();  // ✅ modo corretto
                l.setDisponibile(true);
            }
        }
    }

    

}

class Prenotazione{
    private Utente utente;
    private Libro libro;

    public Prenotazione(Utente u, Libro l){
        this.utente = u;
        this.libro = l;
    }

    @Override
    public boolean equals(Object o){
        if(o==this)
            return true;
        if(!(o instanceof Prenotazione))
            return false;
        
        Prenotazione prenotazione = (Prenotazione)o;
        return prenotazione.getUtente().getNome().equals(this.getUtente().getNome()) && prenotazione.getLibro().getTitolo().equals(this.getLibro().getTitolo());
    }

    public Utente getUtente(){
        return utente;
    }

    public Libro getLibro(){
        return libro;
    }
}

class Libro{
    private String nome;
    private boolean disponibile;

    public Libro(String n){
        this.nome = n;
        this.disponibile = true;
    }

    public void setDisponibile(boolean b){
        disponibile = b;
    }
    public boolean isDisponibile(){
        return disponibile;
    }
    public String getTitolo(){
        return this.nome;
    }
    


}