package Facile;
import java.util.Scanner;

public class es2 {
    public static void main(String[] args) {
        
        int somma = 0, ins = 0;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Inserisci intero da sommare (-1 per terminare): ");
            ins = sc.nextInt();
            if(ins != -1)
                somma+=ins;

        }while(ins != -1);
        
        System.out.println("Somma: " + somma);
        sc.close();
    
    }
        
}
