import java.util.*;

public class Es50 {
    public static void main(String[] args){
        MetodoPagamento carta = new CartaDiCredito("Andrea", "1234-5678-9012-3456");
        MetodoPagamento paypal = new PayPal("andrea@prova.com");

        eseguiPagamento(carta, 100.50);
        eseguiPagamento(paypal, 200.75);
    }

    public static void eseguiPagamento(MetodoPagamento metodo, double importo){
        metodo.paga(importo);
    }
}

interface MetodoPagamento {
    void paga(double importo);
}

class CartaDiCredito implements MetodoPagamento {
    private String titolare;
    private String numeroCarta;

    public CartaDiCredito(String titolare, String numeroCarta){
        this.titolare = titolare;
        this.numeroCarta = numeroCarta;
    }

    public void paga(double importo){
        System.out.println("Pagamento di: " + importo + " Carta di Credito di: " + titolare +
                           ", numero carta: " + numeroCarta);
    }
}

class PayPal implements MetodoPagamento {
    private String email;

    public PayPal(String email){
        this.email = email;
    }

    public void paga(double importo){
        System.out.println("Pagamento di: " + importo + ", PayPal con email: " + email);
    }
}