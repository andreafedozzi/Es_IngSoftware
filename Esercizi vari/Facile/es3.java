package Facile;
public class es3 {
    public static void main(String[] args) {
        Forma[] forme = new Forma[10];

        forme[0] = new Cerchio(10);
        forme[1] = new Rettangolo(9,8);
        forme[2] = new Cerchio(5);

        for(int i = 0; forme[i]!=null; i++){
            System.out.println(forme[i].toString());
        }

    }
}

abstract class Forma{
    public abstract double area();
}

class Cerchio extends Forma{
    private double raggio;

    public Cerchio(double r){
        this.raggio = r;
    }
    
    public double area(){
        return raggio*raggio*3.14;
    }

    public String toString(){
        return "Cerchio, area: " + this.area();
    }
}

class Rettangolo extends Forma{
    private double altezza,base;

    public Rettangolo(double h, double b){
        this.altezza = h;
        this.base = b;
    }

    public double area(){
        return base*altezza;
    }

    public String toString(){
        return "Rettangolo, area: " + this.area();
    }
}
