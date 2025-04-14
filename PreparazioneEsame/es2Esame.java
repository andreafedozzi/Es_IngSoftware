public class es2Esame {
    public static void main(String args[]){
        AutoElettrica a = new AutoElettrica("AA111AA", 0);

        System.out.println(a.statoBatteria());
        a.caricaBatteria();
        System.out.println(a.statoBatteria());
        a.muoviti();
    }
}

abstract class Veicolo{
    private String targa;

    public Veicolo(String targa){
        this.targa = targa;
    }

    public String getTarga(){
        return targa;
    }

    public abstract void muoviti();

}

interface Elettrica{
    public void caricaBatteria();
    public int statoBatteria();
}

class AutoElettrica extends Veicolo implements Elettrica{
    private int livelloBatteria;

    public AutoElettrica(String targa, int bat){
        super(targa);
        this.livelloBatteria = bat;
    }

    public void caricaBatteria(){
        this.livelloBatteria = 100;
    }

    public int statoBatteria(){
        return this.livelloBatteria;
    }

    public void muoviti(){
        System.out.println(getTarga() + " si sta muovendo....");
    }
}