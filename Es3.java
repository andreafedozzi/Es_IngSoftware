package Esercizi1;
public class Es3{
    public static void main(String args[]){

        int i = 0;

        Cane[] cani = new Cane[5];
        Gatto[] gatti = new Gatto[5];

        cani[0] = new Cane("Fido");
        cani[1] = new Cane("Snoopy");
        gatti[0] = new Gatto("Briciola");
        gatti[1] = new Gatto("Silvestro");

        for(i=0; i < cani.length && cani[i] != null; i++){
            cani[i].emettiVerso();
            cani[i].muoviti();
        }

        for(i=0; i < gatti.length && gatti[i] != null; i++){
            gatti[i].emettiVerso();
            gatti[i].muoviti();
        }

        /*cani[0].emettiVerso();
        cani[0].muoviti();
        cani[1].emettiVerso();
        cani[1].muoviti();*/

        /*gatti[0].emettiVerso();
        gatti[0].muoviti();
        gatti[1].emettiVerso();
        gatti[1].muoviti();*/

    }
}

interface Animale{

    public void emettiVerso();

    public void muoviti();

}

abstract class AnimaleBase implements Animale{

    protected String nome;
    
    public AnimaleBase(String nome){
        this.nome = nome;
    }

}

class Cane extends AnimaleBase{

    public Cane(String name){
        super(name);
    }

    @Override
    public void emettiVerso(){
        System.out.println("Bau!");
    }

    @Override
    public void muoviti(){
        System.out.println(this.nome + " si muove... \n");
    }

}

class Gatto extends AnimaleBase{

    public Gatto(String name){
        super(name);
    }

    @Override
    public void emettiVerso(){
        System.out.println("Miao!");
    }

    @Override
    public void muoviti(){
        System.out.println(this.nome + " si muove... \n");
    }

}