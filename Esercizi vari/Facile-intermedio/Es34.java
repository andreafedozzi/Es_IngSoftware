import java.util.*;

public class Es34 {
    public static void main(String[] args) {
        List<SquadraNazionale> classifica = new ArrayList<>();
        classifica.add(new SquadraNazionale("Italia", 15));
        classifica.add(new SquadraNazionale("Francia", 18));
        classifica.add(new SquadraNazionale("Spagna", 12));
        classifica.add(new SquadraNazionale("Germania", 20));

        Collections.sort(classifica);

        for (SquadraNazionale squadra : classifica) {
            System.out.println(squadra.getNome() + " - Punti: " + squadra.getPunti());
        }
    }
}

class SquadraNazionale implements Comparable<SquadraNazionale> {
    private String nome;
    private int punti;

    public SquadraNazionale(String nome, int punti) {
        this.nome = nome;
        this.punti = punti;
    }

    public String getNome() {
        return nome;
    }

    public int getPunti() {
        return punti;
    }

    @Override
    public int compareTo(SquadraNazionale altra) {
        return Integer.compare(altra.getPunti(), this.punti);
    }
}