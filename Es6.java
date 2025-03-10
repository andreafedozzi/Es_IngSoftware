package Esercizi1;
import java.util.*;

public class Es6 {
    public static void main(String[] args) {
        SistemaPagamenti sistema = new SistemaPagamenti();

        MetodoPagamento carta = new CartaDiCredito(500, "1234-5678-9876-5432");
        MetodoPagamento paypal = new PayPal(200, "utente@example.com");

        sistema.aggiungiMetodoPagamento(carta);
        sistema.aggiungiMetodoPagamento(paypal);

        sistema.mostraMetodiPagamento();

        try {
            carta.effettuaPagamento(100);
            paypal.effettuaPagamento(250); // Questo genererà un'eccezione
        } catch (SaldoInsufficienteException e) {
            System.out.println("Errore: " + e.getMessage());
        }

        sistema.mostraMetodiPagamento();
    }
}

interface Pagabile {
    void effettuaPagamento(double importo) throws SaldoInsufficienteException;
}

class SaldoInsufficienteException extends Exception {
    public SaldoInsufficienteException(String message) {
        super(message);
    }
}

abstract class MetodoPagamento implements Pagabile {
    protected double saldoDisponibile;

    public MetodoPagamento(double saldoDisponibile) {
        this.saldoDisponibile = saldoDisponibile;
    }

    @Override
    public void effettuaPagamento(double importo) throws SaldoInsufficienteException {
        if (importo > saldoDisponibile) {
            throw new SaldoInsufficienteException("Saldo insufficiente per il pagamento di €" + importo);
        }
        saldoDisponibile -= importo;
        System.out.println("Pagamento di €" + importo + " effettuato con successo. Saldo rimanente: €" + saldoDisponibile);
    }
}


class CartaDiCredito extends MetodoPagamento {
    private String numeroCarta;

    public CartaDiCredito(double saldoDisponibile, String numeroCarta) {
        super(saldoDisponibile);
        this.numeroCarta = numeroCarta;
    }

    @Override
    public void effettuaPagamento(double importo) throws SaldoInsufficienteException {
        System.out.println("Tentativo di pagamento con Carta di Credito (" + numeroCarta + ")");
        super.effettuaPagamento(importo);
    }
}


class PayPal extends MetodoPagamento {
    private String email;

    public PayPal(double saldoDisponibile, String email) {
        super(saldoDisponibile);
        this.email = email;
    }

    @Override
    public void effettuaPagamento(double importo) throws SaldoInsufficienteException {
        System.out.println("Tentativo di pagamento con PayPal (" + email + ")");
        super.effettuaPagamento(importo);
    }
}


class SistemaPagamenti {
    private List<MetodoPagamento> metodiDiPagamento = new ArrayList<>();

    public void aggiungiMetodoPagamento(MetodoPagamento metodo) {
        metodiDiPagamento.add(metodo);
    }

    public void mostraMetodiPagamento() {
        System.out.println("Metodi di pagamento disponibili:");
        for (MetodoPagamento metodo : metodiDiPagamento) {
            System.out.println(metodo.getClass().getSimpleName() + " - Saldo: €" + metodo.saldoDisponibile);
        }
    }
}