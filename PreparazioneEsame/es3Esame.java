import java.util.*;

public class es3Esame {
    public static void main(String[] args) {
        Smartphone s = new Smartphone("abc123", 78);
        Computer c = new Computer("def456", "MacOS");
        Router r = new Router();

        s.accendi();
        c.accendi();
        r.connetti();
        s.connetti(r);
        c.connetti(r);

        System.out.println("Livello batteria: " + s.livelloBatteria());
        System.out.println("Sistema operativo: " + c.getSistemaOperativo());

        System.out.println("Dispositivi connessi al router: ");
        List<Dispositivo> disp = r.listaDispositiviConnessi();
        for(Dispositivo d : disp){
            System.out.println(d.getId());
        }

    }
}

interface Connesso{
    void connetti(Router r);
    void disconnetti(Router r);
    public boolean statoConnessione();
}

abstract class Dispositivo{
    private String id;

    public Dispositivo(String id){
        this.id = id;
    }
    
    public String getId(){
        return id;
    }

    public abstract void accendi();
    public abstract void spegni();
    public abstract void setStato(boolean b);

}

class Computer extends Dispositivo implements Connesso{
    private String SistemaOperativo;
    private boolean stato;

    public Computer(String id, String sis){
        super(id);
        this.SistemaOperativo = sis;
    }

    public void accendi(){
        System.out.println(this.getId() + " acceso!");
    }
    public void spegni(){
        System.out.println(this.getId() + " spento!");
    }
    public void connetti(Router r){
        r.connettiDispositivo(this);
    }
    public void disconnetti(Router r){
        r.disconnettiDispositivo(this);
    }

    public boolean statoConnessione(){
        return stato;
    }

    public String getSistemaOperativo(){
        return this.SistemaOperativo;
    }

    public void setStato(boolean b){
        this.stato = b;
    }
}

class Smartphone extends Dispositivo implements Connesso{
    private int batteria;
    private boolean stato;

    public Smartphone(String id, int b){
        super(id);
        this.batteria = b;
    }

    public void accendi(){
        System.out.println(this.getId() + " acceso!");
    }
    public void spegni(){
        System.out.println(this.getId() + " spento!");
    }
    public void connetti(Router r){
        r.connettiDispositivo(this);
    }
    public void disconnetti(Router r){
        r.disconnettiDispositivo(this);
    }

    public boolean statoConnessione(){
        return stato;
    }

    public int livelloBatteria(){
        return this.batteria;
    }

    public void setStato(boolean b){
        this.stato = b;
    }
}

class Router{
    private List<Dispositivo> dispositiviConessi;
    private boolean stato;

    public Router(){
        dispositiviConessi = new ArrayList<>();
    }

    public void connettiDispositivo(Dispositivo d){
        if(this.stato == true){
            dispositiviConessi.add(d);
            d.setStato(true);
            System.out.println(d.getId() + " connesso al router!");
        }
        else{
            d.setStato(false);
            System.out.println("Impossibile connettere al router");
        }
    }
    public void disconnettiDispositivo(Dispositivo d){
        dispositiviConessi.remove(d);
        System.out.println(d.getId() + " disconnesso dal router!");
    }
    public void connetti(){
        System.out.println("Router connesso!");
        this.stato = true;
    }
    public void disconnetti(){
        System.out.println("Router disconnesso!");
        this.stato = false;
    }
    public boolean statoConnessione(){
        return stato;
    }

    public List<Dispositivo> listaDispositiviConnessi(){
        return dispositiviConessi;
    }

}