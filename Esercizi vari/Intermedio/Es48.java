import java.util.*;

public class Es48{
    public static void main(String[] args){
        Votazione votazione = new Votazione(5);

        votazione.inserisciVoto(25);
        votazione.inserisciVoto(30);
        votazione.inserisciVoto(28);
        votazione.inserisciVoto(18);
        votazione.inserisciVoto(22);

        System.out.println("Media voti: " + votazione.calcolaMedia());
        System.out.println("Voto massimo: " + votazione.votoMassimo());
        System.out.println("Voto minimo: " + votazione.votoMinimo());
    }
}

class Votazione {
    private int[] voti;
    private int indice;

    public Votazione(int numeroVoti){
        voti = new int[numeroVoti];
        indice = 0;
    }

    public void inserisciVoto(int voto){
        if(indice < voti.length){
            voti[indice] = voto;
            indice++;
        }
    }

    public double calcolaMedia(){
        int somma = 0;
        for(int voto : voti){
            somma += voto;
        }
        return (double) somma / voti.length;
    }

    public int votoMassimo(){
        int massimo = voti[0];
        for(int voto : voti){
            if(voto > massimo){
                massimo = voto;
            }
        }
        return massimo;
    }

    public int votoMinimo(){
        int minimo = voti[0];
        for(int voto : voti){
            if(voto < minimo){
                minimo = voto;
            }
        }
        return minimo;
    }
}