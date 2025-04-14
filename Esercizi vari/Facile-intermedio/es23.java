import java.util.*;

public class es23 {
    public static void main(String[] args) {
        ArrayList<Visita> registroVisite = new ArrayList<>();

        Medico medico1 = new Medico("Rossi", "Pediatra");
        Medico medico2 = new Medico("Bianchi", "Ortopedico");

        Paziente paziente1 = new Paziente("Andrea", "123456");
        Paziente paziente2 = new Paziente("Paolo", "67890");

        registroVisite.add(new Visita(paziente1, medico1, "12/04", "Controllo"));
        registroVisite.add(new Visita(paziente2, medico2, "13/04", "Risonanza"));
        registroVisite.add(new Visita(paziente1, medico2, "14/04", "Gesso"));

        System.out.println("Visite Andrea:");
        for (Visita visita : registroVisite) {
            if (visita.getPaziente().getNome().equals("Andrea")) {
                System.out.println(visita);
            }
        }
    }
}

class Paziente {
    private String nome;
    private String idPaziente;

    public Paziente(String nome, String idPaziente) {
        this.nome = nome;
        this.idPaziente = idPaziente;
    }

    public String getNome() {
        return nome;
    }

    public String getIdPaziente() {
        return idPaziente;
    }
}

class Medico {
    private String nome;
    private String specializzazione;

    public Medico(String nome, String specializzazione) {
        this.nome = nome;
        this.specializzazione = specializzazione;
    }

    public String getNome() {
        return nome;
    }

    public String getSpecializzazione() {
        return specializzazione;
    }
}

class Visita {
    private Paziente paziente;
    private Medico medico;
    private String data;
    private String descrizione;

    public Visita(Paziente paziente, Medico medico, String data, String descrizione) {
        this.paziente = paziente;
        this.medico = medico;
        this.data = data;
        this.descrizione = descrizione;
    }

    public Paziente getPaziente() {
        return paziente;
    }

    public Medico getMedico() {
        return medico;
    }

    public String getData() {
        return data;
    }

    public String getDescrizione() {
        return descrizione;
    }

    @Override
    public String toString() {
        return "Data: " + data + ", Medico: " + medico.getNome() + " (" + medico.getSpecializzazione() + "), Descrizione: " + descrizione;
    }
}