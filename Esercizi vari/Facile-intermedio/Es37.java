import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Es37 {
    public static void main(String[] args) {
        int[] voti = {28, 30, 18, 28, 26, 30, 18, 30, 27};

        System.out.println("Media: " + Statistiche.calcolaMedia(voti));
        System.out.println("Moda: " + Statistiche.calcolaModa(voti));
        System.out.println("Mediana: " + Statistiche.calcolaMediana(voti));
    }
}

class Statistiche {
    public static double calcolaMedia(int[] voti) {
        int somma = 0;
        for (int voto : voti) {
            somma += voto;
        }
        return (double) somma / voti.length;
    }

    public static int calcolaModa(int[] voti) {
        Map<Integer, Integer> frequenze = new HashMap<>();
        for (int voto : voti) {
            frequenze.put(voto, frequenze.getOrDefault(voto, 0) + 1);
        }
        int moda = voti[0];
        int maxFrequenza = 0;
        for (Map.Entry<Integer, Integer> entry : frequenze.entrySet()) {
            if (entry.getValue() > maxFrequenza) {
                moda = entry.getKey();
                maxFrequenza = entry.getValue();
            }
        }
        return moda;
    }

    public static double calcolaMediana(int[] voti) {
        Arrays.sort(voti);
        int n = voti.length;
        if (n % 2 == 0) {
            return (voti[n / 2 - 1] + voti[n / 2]) / 2.0;
        } else {
            return voti[n / 2];
        }
    }
}