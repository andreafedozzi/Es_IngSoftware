import java.util.*;

public class Es44 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci primo numero:");
        double a = scanner.nextDouble();
        System.out.println("Inserisci secondo numero:");
        double b = scanner.nextDouble();
        System.out.println("Scegli l'operazione (+, -, *, /):");
        String operazione = scanner.next();

        Operazione op;
        switch (operazione) {
            case "+":
                op = new Somma(a, b);
                break;
            case "-":
                op = new Sottrazione(a, b);
                break;
            case "*":
                op = new Moltiplicazione(a, b);
                break;
            case "/":
                op = new Divisione(a, b);
                break;
            default:
                System.out.println("Operazione non valida");
                return;
        }
        System.out.println("Risultato: " + op.calcola());
    }
}

abstract class Operazione {
    protected double a, b;

    public Operazione(double a, double b){
        this.a = a;
        this.b = b;
    }

    public abstract double calcola();
}

class Somma extends Operazione {
    public Somma(double a, double b){
        super(a, b);
    }

    public double calcola(){
        return a + b;
    }
}

class Sottrazione extends Operazione {
    public Sottrazione(double a, double b){
        super(a, b);
    }

    public double calcola(){
        return a - b;
    }
}

class Moltiplicazione extends Operazione {
    public Moltiplicazione(double a, double b){
        super(a, b);
    }

    public double calcola(){
        return a * b;
    }
}

class Divisione extends Operazione {
    public Divisione(double a, double b){
        super(a, b);
    }

    public double calcola(){
        if (b == 0) {
            System.out.println("Divisione per zero non consentita");
            System.exit(1);
        }
        return a / b;
    }
}