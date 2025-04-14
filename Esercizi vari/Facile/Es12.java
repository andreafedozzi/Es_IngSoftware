package Facile;

public class Es12 {
    public static void main(String[] args) {
        int lung = 10;
        Studente[] studenti = new Studente[lung];
        
        for(int i = 0; i<lung; i++){
            studenti[i] = new Studente("abc"+i, "s"+i, 10+i);
        }
        for(int i = 0; i<lung; i++){
            System.out.println(studenti[i].toString());
        }

    }
}

class Studente{
    private String matricola, nome;
    private int npresenze;

    public Studente(String matr, String n, int npresenze){
        this.matricola = matr;
        this.nome = n;
        this.npresenze = npresenze;
    }

    public int getPresenze(){
        return this.npresenze;
    }

    public String toString(){
        return this.nome + " " + this.matricola + " " + this.npresenze;
    }


}
