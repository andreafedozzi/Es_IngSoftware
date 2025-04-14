package Facile;
import java.util.*;

public class Es7 {
    public static void main(String[] args) {
        int[] numeri = {1,2,3,4,5};
    String[] stringhe = {"Prova","Ciao","Abc"};

    Contatore<Integer> contatoreNumeri = new Contatore<>();
    Contatore<String> contatoreStringhe = new Contatore<>();

    for(Integer n : numeri){
        contatoreNumeri.aggiungi(n);
    }
    for(String s : stringhe){
        contatoreStringhe.aggiungi(s);
    }

    System.out.println("Numeri: " + contatoreNumeri.conta());
    System.out.println("Stringhe: " + contatoreStringhe.conta());
    }

}

class Contatore<T>{
    private List <T> elementi;

    public Contatore(){
        elementi = new ArrayList<>();
    }

    public void aggiungi(T elemento){
        elementi.add(elemento);
    }

    public int conta(){
        return elementi.size();
    }

}