package Facile;

public class Es9 {
    public static void main(String[] args) {
        Persona p = new Persona("Andrea", 21);
        System.out.println(p.toString());
        p.setNome("Gianni");
        p.setEta(44);
        System.out.println(p.toString());
    }
}

class Persona{
    private String nome;
    private int eta;

    public Persona(String nome, int eta){
        this.nome = nome;
        this.eta = eta;
    }

    public int getEta(){
        return this.eta;
    }
    public String getNome(){
        return this.nome;
    }
    public void setEta(int eta){
        this.eta = eta;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String toString(){
        return this.nome + " " + this.eta;
    }


}
