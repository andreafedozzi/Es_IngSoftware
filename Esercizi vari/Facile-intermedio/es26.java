import java.io.*;
import java.util.*;

public class es26 {
    public static void main(String[] args) {
        String inputFile = "studenti.txt";
        String outputFile = "media_voti.txt";
        ArrayList<Studente> studenti = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String nome = parts[0].trim();
                double voto = Double.parseDouble(parts[1].trim());
                studenti.add(new Studente(nome, voto));
            }
        } catch (IOException e) {
            System.out.println("Errore durante la lettura del file: " + e.getMessage());
        }

        double somma = 0;
        for (Studente s : studenti) {
            somma += s.getVoto();
        }
        double media = studenti.isEmpty() ? 0 : somma / studenti.size();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write("Media voti: " + media);
            System.out.println("La media è stata calcolata e salvata in " + outputFile);
        } catch (IOException e) {
            System.out.println("Errore durante la scrittura del file: " + e.getMessage());
        }
    }
}

class Studente {
    private String nome;
    private double voto;

    public Studente(String nome, double voto) {
        this.nome = nome;
        this.voto = voto;
    }

    public String getNome() {
        return nome;
    }

    public double getVoto() {
        return voto;
    }
}