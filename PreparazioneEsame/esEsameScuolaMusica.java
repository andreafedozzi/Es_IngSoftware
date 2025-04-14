import java.util.*;

import javax.crypto.AEADBadTagException;

public class esEsameScuolaMusica{
    public static void main(String[] args) {
        
        ScuolaMusica s = new ScuolaMusica();

        Studente s1 = new Studente("aaa", "Andrea", "Tromba");
        Studente s2 = new Studente("bbb","Luca","Oboe");
        s.aggiungiStudente(s1);
        s.aggiungiStudente(s2);

        Insegnante i1 = new Insegnante("123", "Mario", "Tromba");
        Insegnante i2 = new Insegnante("456", "Prova", "Oboe");
        s.aggiungiInsegnante(i1);
        s.aggiungiInsegnante(i2);

        Lezione l1 = new Lezione("jcncivon", "Oboe","1203");
        Lezione l2 = new Lezione("ncienvpo","Tromba","2207");
        i1.aggiungiLezione(l1);
        i2.aggiungiLezione(l2);

        Corso c1 = new Corso("provacorso","ncip","ncks","Mario");
        Corso c2 = new Corso("vndop","hcvinv","ncdin","nvdio");
        s.aggiungiCorso(c1);
        s.aggiungiCorso(c2);

        s.trovaLezioniDisponibili("Oboe");
        s1.prenotaLezione(l2);
        s.trovaLezioniDisponibili("Oboe");

        s.visualizzaCorsi();

        

    }
}

class Studente{
    private String idStudente, nome, strumento;
    private List<Lezione> lezioniPrenotate;

    public Studente(String id, String nome, String strum){
        this.idStudente = id;
        this.nome = nome;
        this.strumento = strum;
        lezioniPrenotate = new ArrayList<>();
    }

    public void prenotaLezione(Lezione l){
        if(l.isDisponibile() && this.strumento.equals(l.getStrumento())){
            lezioniPrenotate.add(l);
            l.prenotaLezione();
        }
        else
            System.out.println("Lezione non disponibile!");
    }

    public void visualizzaLezione(){
        for(Lezione l : lezioniPrenotate){
            System.out.println(l.toString());
        }
    }

    public String toString(){
        return this.idStudente + " " + this.nome + " " + this.strumento;
    }

}

class Lezione{
    private String idLezione, strumento, dataOra;
    private boolean occupata;

    public Lezione(String idLezione, String strumento, String dataOra){
        this.idLezione = idLezione;
        this.strumento = strumento;
        this.dataOra = dataOra;
        this.occupata = false;
    }

    public void prenotaLezione(){
        occupata = !false;
    }
    public void liberaLezione(){
        occupata = !true;
    }
    public boolean isDisponibile(){
        return !occupata;
    }

    public String toString(){
        return this.idLezione + " " + this.dataOra + " " + this.strumento + " Occupata: " + this.occupata;
    }

    public String getStrumento(){
        return this.strumento;
    }


}

class Insegnante{
    private String idInsegnante, nome, strumentoSpecializzato;
    private List<Lezione> lezioniDisponibili;

    public Insegnante(String idInsegnante, String nome, String strumentoSpecializzato){
        this.idInsegnante = idInsegnante;
        this.nome = nome;
        this.strumentoSpecializzato = strumentoSpecializzato;
        lezioniDisponibili = new ArrayList<>();
    }

    public void aggiungiLezione(Lezione l){
        lezioniDisponibili.add(l);
    }
    public void visualizzaLezioniDisp(){
        System.out.println("Lezioni disponibili: ");
        for(Lezione l : lezioniDisponibili){
            System.out.println(l.toString());
        }
    }

    public String getStrumentoSpecializzato(){
        return this.strumentoSpecializzato;
    }

    public void check(String strumento){
        System.out.println("Lezioni disponibili per " + strumento + ": ");
        for(Lezione lDisp : lezioniDisponibili){
            if(lDisp.getStrumento().equals(strumento)){
                System.out.println(lDisp.toString());
            }
        }
    }

}

class Corso{
    private String idCorso, nome, strumento, insegnante;
    private List<Studente> studenti;

    public Corso(String idCorso, String nome, String strumento, String insegnante){
        this.idCorso = idCorso;
        this.nome = nome;
        this.strumento = strumento;
        this.insegnante = insegnante;
        studenti = new ArrayList<>();
    }

    public void aggiungiStudente(Studente s){
        studenti.add(s);
    }
    public void visualizzaStudenti(){
        for(Studente s : studenti){
            System.out.println(s.toString());
        }
    }

    public String toString(){
        return this.idCorso + " " + this.nome + " " + this.strumento + " " + this.insegnante;
    }

}

class ScuolaMusica{
    private List<Studente> studenti;
    private List<Insegnante> insegnanti;
    private List<Corso> corsi;

    public ScuolaMusica(){
        this.studenti = new ArrayList<>();
        this.insegnanti = new ArrayList<>();
        this.corsi = new ArrayList<>();
    }

    public void aggiungiStudente(Studente s){
        studenti.add(s);
    }
    public void rimuoviStudente(Studente s){
        studenti.remove(s);
    }
    public void aggiungiInsegnante(Insegnante i){
        insegnanti.add(i);
    }
    public void rimuoviInsegnante(Insegnante i){
        insegnanti.remove(i);
    }
    public void aggiungiCorso(Corso c){
        corsi.add(c);
    }
    public void rimuoviCorso(Corso c){
        corsi.remove(c);
    }

    public void trovaLezioniDisponibili(String strumento){
        for(Insegnante i : insegnanti){
            if(i.getStrumentoSpecializzato().equals(strumento)){
                i.check(strumento);
            }
        }
    }

    public void visualizzaCorsi(){
        System.out.println("Lista Corsi:");
        for(Corso c : corsi){
            System.out.println(c.toString());
        }
    }

}