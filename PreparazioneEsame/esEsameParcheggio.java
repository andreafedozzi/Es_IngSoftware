import java.util.*;

public class esEsameParcheggio {
    public static void main(String[] args) {
        
        Parcheggio p = new Parcheggio();

        PostoAuto posto1 = new PostoAuto(1, 1, "Auto");
        PostoAuto posto2 = new PostoAuto(2,1,"Auto");
        PostoAuto posto3 = new PostoAuto(3,1,"Moto");

        Veicolo v1 = new Veicolo("ABC", "Auto", "blu");
        Cliente c1 = new Cliente("123ABC","Andrea",v1);
        
        Veicolo v2 = new Veicolo("DEF","Moto","rossa");
        Cliente c2 = new Cliente("456DEF","Gianni",v2);

        GestoreParcheggio g = new GestoreParcheggio("Pino", "999aaa");

        g.aggiungiCliente(c1, p);
        g.aggiungiCliente(c2, p);

        p.aggiungiPosto(posto1);
        p.aggiungiPosto(posto2);
        p.aggiungiPosto(posto3);

        p.visualizzaPostiDisponibili();

        p.parcheggiaVeicolo(c1, v1);
        p.parcheggiaVeicolo(c2, v2);

        p.visualizzaPostiDisponibili();

        p.liberaPosto(1);

        p.visualizzaPostiDisponibili();

    }
}

class Veicolo{
    private String targa, tipo, colore;
    
    public Veicolo(String targa, String tipo, String colore){
        this.targa = targa;
        this.tipo = tipo;
        this.colore = colore;
    }

    public String toString(){
        return this.targa + " " + this.tipo + " " + this.colore;
    }

    public String getTipo(){
        return tipo;
    }

}

class Cliente{
    private String idcliente, nome;
    private Veicolo v;

    public Cliente(String idcliente, String nome, Veicolo veicolo){
        this.idcliente = nome;
        this.nome = nome;
        this.v = veicolo;
    }

    public String toString(){
        return this.idcliente + " " + this.nome + " " + v.toString();
    }
}

class PostoAuto{
    private int nPosto, piano;
    private boolean occupato;
    private String tipoVeicoloConsentito;

    public PostoAuto(int nPosto, int piano, String tvc){
        this.nPosto = nPosto;
        this.piano = piano;
        this.tipoVeicoloConsentito = tvc;
    }

    public void liberaPosto(){
        this.occupato = false;
    }
    public void setOccupato(){
        this.occupato = true;
    }
    
    public String getTipoVeicoloConsentito(){
        return tipoVeicoloConsentito;
    }

    public boolean isDisponibile(){
        return !occupato;
    }

    public int getNumeroPosto(){
        return nPosto;
    }

    public String toString(){
        return this.nPosto + " " + this.piano + " " + this.tipoVeicoloConsentito + " " + !this.occupato;
    }

}

class GestoreParcheggio{
    private String nome, idGestore;

    public GestoreParcheggio(String nome, String idGestore){
        this.nome = nome;
        this.idGestore = idGestore;
    }

    public void aggiungiCliente(Cliente c, Parcheggio p){
        p.aggiungiCliente(c);
    }

    public void rimuoviCliente(Cliente c, Parcheggio p){
        p.rimuoviCliente(c);
    }   

}

class Parcheggio{
    private List<PostoAuto> posti;
    private List<Cliente> clienti;

    public Parcheggio(){
        posti = new ArrayList<>();
        clienti = new ArrayList<>();
    }

    public void aggiungiPosto(PostoAuto p){
        posti.add(p);
    }
    public void rimuoviPosto(PostoAuto p){
        posti.remove(p);
    }
    public void aggiungiCliente(Cliente c){
        clienti.add(c);
    }
    public void rimuoviCliente(Cliente c){
        clienti.remove(c);
    }

    public void parcheggiaVeicolo(Cliente c, Veicolo v){

        for(PostoAuto p : posti){

            if(v.getTipo().equals(p.getTipoVeicoloConsentito()) && p.isDisponibile()==true){
                p.setOccupato();
                System.out.println("Parcheggio trovato!");
                break;
            }
        }

    }

    public void liberaPosto(int numeroPosto){
        for(PostoAuto p : posti){
            if(p.getNumeroPosto() == numeroPosto){
                p.liberaPosto();
                System.out.println("Posto liberato!");
            }
        }
    }

    public void visualizzaPostiDisponibili(){
        System.out.println("Posti disponibili");
        for(PostoAuto p : posti){
            if(p.isDisponibile() == true){
                System.out.println(p.toString());
            }
        }
    }

}