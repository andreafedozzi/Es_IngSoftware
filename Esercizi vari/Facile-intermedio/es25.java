import java.util.*;

public class es25 {
    public static void main(String[] args) {
        List<ContoBancario> conti = new ArrayList<>();

        conti.add(new ContoCorrente("IT1234567890", 1500));
        conti.add(new ContoRisparmio("IT0987654321", 3000));

        for (ContoBancario conto : conti) {
            System.out.println("Conto: " + conto.getIban() + ", Interesse calcolato: " + conto.calcolaInteresse());
        }
    }
}

abstract class ContoBancario {
    private String iban;
    private double saldo;

    public ContoBancario(String iban, double saldo) {
        this.iban = iban;
        this.saldo = saldo;
    }

    public String getIban() {
        return iban;
    }

    public double getSaldo() {
        return saldo;
    }

    public abstract double calcolaInteresse();
}

class ContoCorrente extends ContoBancario {
    private static final double TASSO_INTERESSE = 0.01;

    public ContoCorrente(String iban, double saldo) {
        super(iban, saldo);
    }

    @Override
    public double calcolaInteresse() {
        return getSaldo() * TASSO_INTERESSE;
    }
}

class ContoRisparmio extends ContoBancario {
    private static final double TASSO_INTERESSE = 0.03;

    public ContoRisparmio(String iban, double saldo) {
        super(iban, saldo);
    }

    @Override
    public double calcolaInteresse() {
        return getSaldo() * TASSO_INTERESSE;
    }
}