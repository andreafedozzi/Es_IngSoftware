package Facile;
import java.util.*;

public class es4 {
    public static void main(String[] args) {
        ArrayList<Studente> studenti = new ArrayList<>();
        Studente s1 = new Studente("Andrea", "12345");
        Studente s2 = new Studente("Paolo", "67890");
        studenti.add(s1);
        studenti.add(s2);

        s1.inserisciVoti(5);
        s2.inserisciVoti(4);

        int[] vS1 = s1.getVoti();
        int[] vS2 = s2.getVoti();

        int somma = 0;
        for(int i = 0; i<vS1.length; i++){
            somma += vS1[i];
        }
        System.out.println("Media: " + somma/vS1.length);
        
        somma = 0;
        for(int i = 0; i<vS2.length; i++){
            somma += vS2[i];
        }
        System.out.println("Media: " + somma/vS2.length);

    }
}

class Studente{
    private String nome, matricola;
    private int[] voti;
    Scanner sc;

    public Studente(String nome, String matricola){
        this.nome = nome;
        this.matricola = matricola;
    }

    public void inserisciVoti(int nVoti){
        voti = new int[nVoti];
        sc = new Scanner(System.in);
        for(int i=0; i<nVoti; i++){
            System.out.println("Inserisci voto: ");
            voti[i] = sc.nextInt();
        }
    }

    public int[] getVoti(){
        return voti;
    }
}
