import java.util.*;

public class esEsameRistorante {
    public static void main(String[] args) {
        
        Ristorante r = new Ristorante();

        Tavolo t = new Tavolo(1, 4, false);
        Cameriere c = new Cameriere("Andrea", 999);
        Piatto p = new Piatto("Tortellini", "In brodo", 14.50);
        r.addPiatto(p);
        r.addCameriere(c);
        r.addTavolo(t);

        c.prendiOrdine(t,1);
        r.visualizzaMenu();
        r.visualizzaOrdini(t);

    }
}

class Tavolo{
    private int numTavolo, postiDisponibili;
    private boolean occupato;
    private List<Ordine> ordini;

    public Tavolo(int numTavolo, int postiDisponibili, boolean occupato){
        this.numTavolo = numTavolo;
        this.postiDisponibili = postiDisponibili;
        this.occupato = occupato;
        ordini = new ArrayList<>();
    }

    public void setStato(boolean b){
        this.occupato = b;
    }

    public int getNumTavolo(){
        return numTavolo;
    }

    public boolean isDisponibile(){
        return !occupato;
    }

    public void addOrdine(Ordine o){
        ordini.add(o);
    }

    public List<Ordine> getListaOrdini(){
        return ordini;
    }

}

class Cameriere{
    private String nome;
    private int numeroCameriere;

    public Cameriere(String nome, int numeroCameriere){
        this.nome = nome;
        this.numeroCameriere = numeroCameriere;
    }

    public void prendiOrdine(Tavolo t, int nOrdine){
        Ordine o = new Ordine(nOrdine,"Vuoto");
        t.setStato(true);
        int i = 1;
        Scanner sc = new Scanner(System.in);
        String nome;
        do{
            System.out.println("Inserisci nome: ");
            nome = sc.nextLine();
            if(!nome.equals("0")){
                Piatto p = new Piatto(nome);
                o.aggiungiPiatto(p);
            }
        }while(!nome.equals("0"));
        o.modificaStato("In preparazione");
        sc.close();
        t.addOrdine(o);
    
    }
}

class Ordine{
    private int numeroOrdine;
    private String stato;
    private List<Piatto> listaPiatti;

    public Ordine(int numeroOrdine, String stato){
        this.numeroOrdine = numeroOrdine;
        this.stato = stato;
        listaPiatti = new ArrayList<>();
    }

    public void aggiungiPiatto(Piatto p){
        listaPiatti.add(p);
    }

    public void modificaStato(String stato){
        this.stato = stato;
    }
    public String toString(){
        String a = this.numeroOrdine + " " + this.stato + " ";
        for(Piatto p : listaPiatti){
            a+=p.stampaNomePiatto() + " ";
        }
        return a;
    }

}

class Piatto{
    private String nome, descrizione;
    private double prezzo;

    public Piatto(String nome, String descrizione, double prezzo){
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
    }

    public Piatto(String nome){
        this.nome = nome;
    }

    public String toString(){
        return this.nome + " " + this.descrizione + " " + this.prezzo;
    }

    public String stampaNomePiatto(){
        return this.nome;
    }

}

class Ristorante{
    private List<Tavolo> tavoli;
    private List<Cameriere> camerieri;
    private List<Piatto> piatti;

    public Ristorante(){
        tavoli = new ArrayList<>();
        camerieri = new ArrayList<>();
        piatti = new ArrayList<>();
    }

    public void addTavolo(Tavolo t){
        tavoli.add(t);
    }
    public void removeTavolo(Tavolo t){
        tavoli.remove(t);
    }
    public void addCameriere(Cameriere c){
        camerieri.add(c);
    }
    public void removeCameriere(Cameriere c){
        camerieri.remove(c);
    }
    public void addPiatto(Piatto p){
        piatti.add(p);
    }
    public void removePiatto(Piatto p){
        piatti.remove(p);
    }

    public void visualizzaMenu(){
        for(Piatto p : piatti){
            System.out.println(p.toString());
        }
    }

    public void visualizzaOrdini(Tavolo t){
        
        for(Ordine o : t.getListaOrdini()){
            System.out.println(o.toString());
        }   

    }

}