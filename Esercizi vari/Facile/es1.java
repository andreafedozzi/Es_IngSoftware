package Facile;
import java.util.*;

public class es1{
    public static void main(String[] args) {
        ArrayList<Contatto> contatti = new ArrayList<>();
        contatti.add(new Contatto("Andrea","2222222222"));
        contatti.add(new Contatto("Paolo", "1111111111"));
        contatti.add(new Contatto("Gino", "9999999999"));

        for(Contatto c : contatti){
            System.out.println(c.toString());
        }


    }
}

class Contatto{
    private String nome;
    private String telefono;

    public Contatto(String nome, String telefono){
        this.nome = nome;
        this.telefono = telefono;
    }

    public void setNome(String n){
        this.nome = n;
    }

    public String getNome(){
        return this.nome;
    }

    public void setTelefono(String t){
        this.telefono = t;
    }

    public String getTelefono(){
        return this.telefono;
    }

    public String toString(){
        return this.nome + " " + this.telefono;
    }


}