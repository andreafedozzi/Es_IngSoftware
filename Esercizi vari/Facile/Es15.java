package Facile;

import java.util.*;

public class Es15 {
    public static void main(String[] args) {
        Libro l1 = new Libro("1984","Orwell",1949);
        Libro l2 = new Libro("La divina commedia","Dante Alighieri",1000);

        List<Libro> libri = new ArrayList<>();
        libri.add(l1);
        libri.add(l2);

        for(Libro l : libri){
            System.out.println(l.toString());
        }

    }
}

class Libro{
    private String titolo, autore;
    private int anno;

    public Libro(String t, String a, int anno){
        this.titolo = t;
        this.autore = a;
        this.anno = anno;
    }

    public String toString(){
        return this.titolo + " " + this.autore + " " +  this.anno;
    }
}
