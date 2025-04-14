import java.util.*;

public class esEsameClubSportivo{
    public static void main(String[] args) {
        ClubSportivo club = new ClubSportivo();

        Attivita calcio = new Attivita("Calcio");
        Attivita nuoto = new Attivita("Nuoto");

        Allenatore a1 = new Allenatore(12, "Andrea", "Calcio");
        Allenatore a2 = new Allenatore(100, "Michele", "Nuoto");

        Socio socio1 = new Socio(15,"Piero","piero@gmail.com","Lodi");
        Socio socio2 = new Socio(818382,"Anna","anna@gmail.com","Bianchi");

        Corso c1 = new Corso(17329,"Corso base Calcio",a1);
        Corso c2 = new Corso(12, "Corso base Nuoto", a2);

        club.aggiungiAllenatore(a1);
        club.aggiungiAllenatore(a2);
        club.aggiungiAttivita(calcio);
        club.aggiungiAttivita(nuoto);
        club.aggiungiSocio(socio2);
        club.aggiungiSocio(socio1);

        club.cercaAllenatoriPerSpecializzazione("Calcio");
        club.cercaSociPerCognome("Zambrini");
        club.visualizzaDettagliAttivita("Nuoto");

    }
}

class Socio{
    private int idSocio;
    private String nome,email,cognome;
    private List<Corso> corsi_iscritti;

    public Socio(int idSocio, String nome, String email, String cognome){
        this.idSocio = idSocio;
        this.nome = nome;
        this.email = email;
        this.cognome = cognome;
        corsi_iscritti = new ArrayList<>();
    }

    public void iscrivitiCorso(Corso c){
        corsi_iscritti.add(c);
    }

    public void visualizzaCorsi(){
        for(Corso c : corsi_iscritti){
            System.out.println(c.toString());
        }
    }

    public String toString(){
        return this.nome + " " + this.cognome + " " + this.email + " " + this.idSocio;
    }

    public String getCognome(){
        return this.cognome;
    }

}

class Allenatore{
    private int idAllenatore;
    private String nome, specializzazione;
    private List<Corso> corsiGestiti;

    public Allenatore(int idAllenatore, String nome, String specializzazione){
        this.idAllenatore = idAllenatore;
        this.nome = nome;
        this.specializzazione = specializzazione;
        corsiGestiti = new ArrayList<>();
    }

    public void aggiungiCorso(Corso c){
        corsiGestiti.add(c);
    }

    public void visualizzaCorsi(){
        for(Corso c : corsiGestiti){
            System.out.println(c.toString());
        }
    }

    public String getNome(){
        return nome;
    }

    public String getSpecializzazione(){
        return specializzazione;
    }

    public String toString(){
        return this.nome + " " + this.idAllenatore + " " + this.specializzazione;
    }

}

class Attivita{
    private String nomeAttivita;
    private List<Corso> corsi;

    public Attivita(String nomeAttivita){
        this.nomeAttivita = nomeAttivita;
        corsi = new ArrayList<>();
    }

    public void aggiungiCorso(Corso c){
        corsi.add(c);
    }
    public void visualizzaCorsi(){
        for(Corso c : corsi){
            System.out.println(c.toString());
        }
    }

    public String getNome(){
        return this.nomeAttivita;
    }

    public String toString(){
        return this.nomeAttivita + " ";
    }

}

class Corso{
    private int idCorso;
    private String nome;
    private Allenatore allenatore;
    private List<Socio> soci_iscritti;

    public Corso(int idCorso, String nome, Allenatore allenatore){
        this.idCorso = idCorso;
        this.nome = nome;
        this.allenatore = allenatore;
    }

    public void aggiungiSocio(Socio s){
        soci_iscritti.add(s);
    }
    
    public void visualizzaSoci(){
        for(Socio s : soci_iscritti){
            System.out.println(s.toString());
        }
    }

    public String toString(){
        return this.nome + " " + this.idCorso + " " + this.allenatore.getNome();
    }

}

class ClubSportivo{

    private List<Socio> soci;
    private List<Allenatore> allenatori;
    private List<Attivita> attivita;

    private List<Socio> soci_trovati;
    private List<Allenatore> allenatori_trovati;
    private List<Attivita> attivita_trovate;

    public ClubSportivo(){
        soci = new ArrayList<>();
        allenatori = new ArrayList<>();
        attivita = new ArrayList<>();
    }

    public void aggiungiSocio(Socio s){
        soci.add(s);
    }
    public void aggiungiAllenatore(Allenatore a){
        allenatori.add(a);
    }
    public void aggiungiAttivita(Attivita a){
        attivita.add(a);
    }

    public void cercaSociPerCognome(String cognome){
        soci_trovati = new ArrayList<>();
        for(Socio s : soci){
            if(s.getCognome().equals(cognome))
                soci_trovati.add(s);
        }

        for(Socio s : soci_trovati){
            System.out.println(s.toString());
        }
    }

    public void cercaAllenatoriPerSpecializzazione(String specializzazione){
        allenatori_trovati = new ArrayList<>();
        for(Allenatore a : allenatori){
            if(a.getSpecializzazione().equals(specializzazione))
                allenatori_trovati.add(a);
        }

        for(Allenatore a : allenatori_trovati){
            System.out.println(a.toString());
        }
    }   
    
    public void visualizzaDettagliAttivita(String nomeAttivita){
        attivita_trovate = new ArrayList<>();
        for(Attivita a : attivita){
            if(a.getNome().equals(nomeAttivita))
                attivita_trovate.add(a);
        }

        for(Attivita a : attivita_trovate){
            System.out.println(a.toString());
        }
        
    }


}