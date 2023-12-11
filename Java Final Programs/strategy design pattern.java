import java.util.Scanner;

// PaymentStrategy interface
interface PaymentStrategy {
    void pay(double amount);
}

// Concrete Credit Card PaymentStrategy
class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card.");
    }
}

// Concrete PayPal PaymentStrategy
class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal.");
    }
}

// Concrete Bitcoin PaymentStrategy
class BitcoinPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Bitcoin.");
    }
}

// Context (Shopping Cart) that uses the PaymentStrategy
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public ShoppingCart(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public void checkout(double amount) {
        paymentStrategy.pay(amount);
    }
}

class Main {
    public static void main(String[] args) {
        // Create a shopping cart with Credit Card payment
        PaymentStrategy creditCardPayment = new CreditCardPayment();
        ShoppingCart cart1 = new ShoppingCart(creditCardPayment);
        cart1.checkout(100.0);
        // Create a shopping cart with PayPal payment
        PaymentStrategy payPalPayment = new PayPalPayment();
        ShoppingCart cart2 = new ShoppingCart(payPalPayment);
        cart2.checkout(75.0);
        // Create a shopping cart with Bitcoin payment
        PaymentStrategy bitcoinPayment = new BitcoinPayment();
        ShoppingCart cart3 = new ShoppingCart(bitcoinPayment);
        cart3.checkout(50.0);
    }
}
