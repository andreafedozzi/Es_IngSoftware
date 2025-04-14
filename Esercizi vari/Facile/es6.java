package Facile;
public class es6 {
    public static void main(String[] args) {
        Animale c = new Cane();
        Animale g = new Gatto();

        c.verso();
        g.verso();
    }
}

interface Animale{
    public void verso();
}

class Cane implements Animale{
    public void verso(){
        System.out.println("Bau!");
    }
}

class Gatto implements Animale{
    public void verso(){
        System.out.println("Miao!");
    }
}
