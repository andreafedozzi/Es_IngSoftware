import java.util.*;
import java.util.stream.Collectors;

public class es30 {
    public static void main(String[] args) {
        ArrayList<Contatto> rubrica = new ArrayList<>();

        rubrica.add(new Contatto("Andrea", "123456789", "andrea@prova.com"));
        rubrica.add(new Contatto("Marco", "987654321", "marco@prova.com"));
        rubrica.add(new Contatto("Lucia", "555666777", "lucia@prova.com"));
        rubrica.add(new Contatto("Giulia", "444555666", "giulia@prova.com"));

        // Ricerca per nome parziale
        System.out.println("Ricerca per nome parziale 'Mar':");
        List<Contatto> ricercaNome = rubrica.stream()
                .filter(c -> c.getNome().toLowerCase().contains("mar"))
                .collect(Collectors.toList());
        ricercaNome.forEach(System.out::println);

        // Ricerca per dominio email
        System.out.println("\nRicerca per dominio prova.com:");
        List<Contatto> ricercaEmail = rubrica.stream()
                .filter(c -> c.getEmail().endsWith("prova.com"))
                .collect(Collectors.toList());
        ricercaEmail.forEach(System.out::println);
    }
}

class Contatto {
    private String nome;
    private String numero;
    private String email;

    public Contatto(String nome, String numero, String email) {
        this.nome = nome;
        this.numero = numero;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getNumero() {
        return numero;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Contatto{" +
               "nome='" + nome + '\'' +
               ", numero='" + numero + '\'' +
               ", email='" + email + '\'' +
               '}';
    }
}