import java.util.*;

interface Paymentprocess {
    void pay(double amount);
}

class CreditCardpayment implements Paymentprocess {
    @Override
    public void pay(double amount) {
        System.out.println("Paid : " + amount + " Using Credit card\n ");

    }
}

class Paypalpayment implements Paymentprocess {
    @Override
    public void pay(double amount) {
        System.out.println("Paid: " + amount + " Using Paypal.\n");
    }
}

class Bitcoinpayment implements Paymentprocess {
    @Override
    public void pay(double amount) {
        System.out.println("Paid: " + amount + " USing Bitcoin.\n");

    }
}

class ShopingCart {
    private Paymentprocess paymentprocess;

    public ShopingCart(Paymentprocess payment) {
        this.paymentprocess = payment;
    }

    public void checkout(double amount) {
        paymentprocess.pay(amount);
    }

}

class Main {
    public static void main(String[] args) {
        System.out.println("payment BY Customer 1:-");
        Paymentprocess creditcardpayment = new CreditCardpayment();
        ShopingCart cart1 = new ShopingCart(creditcardpayment);
        cart1.checkout(100);
        System.out.println("payment BY Customer 2:-");
        Paymentprocess paypalpayment = new Paypalpayment();
        ShopingCart cart2 = new ShopingCart(paypalpayment);
        cart2.checkout(50);
        System.out.println("payment BY Customer 3:-");
        Paymentprocess bitcoinpayment = new Bitcoinpayment();
        ShopingCart cart3 = new ShopingCart(bitcoinpayment);
        cart3.checkout(200);

    }
}