package Facile;
import java.util.*; 

public class Es8{
    public static void main(String[] args) {
        List<Squadra> squadre = new ArrayList<>();

        squadre.add(new Squadra("Milan", 56));
        squadre.add(new Squadra("Juventus", 70));
        squadre.add(new Squadra("Inter", 67));

        for (int i = 0; i < squadre.size(); i++) {
            for (int j = i + 1; j < squadre.size(); j++) {
                if (squadre.get(i).getPunti() < squadre.get(j).getPunti()) {
                    Squadra temp = squadre.get(i);
                    squadre.set(i, squadre.get(j));
                    squadre.set(j, temp);
                }
            }
        }

        for(Squadra s : squadre){
            System.out.println(s.toString());
        }

    }   
}

class Squadra{
    private String nome;
    private int punti;

    public Squadra(String n, int p){
        this.nome = n;
        this.punti = p;
    }

    public String getNome(){
        return nome;
    }

    public int getPunti(){
        return punti;
    }

    public String toString(){
        return this.nome + " " + this.punti;
    }

}