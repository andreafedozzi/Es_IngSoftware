import java.util.*;

public class Es39 {
    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();

        tasks.add(new Task("task1", 3, "20/05"));
        tasks.add(new Task("taks2", 1, "11/06"));
        tasks.add(new Task("task3", 2, "12/12"));
        tasks.add(new Task("task4", 1, "13/04"));

        Collections.sort(tasks);

        for (Task t : tasks) {
            System.out.println(t.getDescrizione() + " , Priorità: " + t.getPriorita() + " , Scadenza: " + t.getScadenza());
        }
    }
}

class Task implements Comparable<Task> {
    private String descrizione;
    private int priorita; 
    private String scadenza;

    public Task(String descrizione, int priorita, String scadenza) {
        this.descrizione = descrizione;
        this.priorita = priorita;
        this.scadenza = scadenza;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public int getPriorita() {
        return priorita;
    }

    public String getScadenza() {
        return scadenza;
    }

    @Override
    public int compareTo(Task altro) {
        if (this.priorita != altro.priorita) {
            return Integer.compare(this.priorita, altro.priorita);
        }
        return this.scadenza.compareTo(altro.scadenza);
    }
}