package Facile;

public class Es13 {
    public static void main(String[] args) {
        Macchina auto = new Auto();
        Macchina moto = new Moto();

        auto.avvia();
        moto.avvia();
    }
}

abstract class Macchina{
    public abstract void avvia();
}

class Auto extends Macchina{
    public Auto(){

    }
    public void avvia(){
        System.out.println("Auto si avvia...");
    }
}

class Moto extends Macchina{
    public Moto(){

    }
    public void avvia(){
        System.out.println("Moto si avvia...");
    }
}
