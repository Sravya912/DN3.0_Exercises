package strategy;

public class Test {
    public static void main(String[] args) {
        PaymentStrategy creditCard = new CreditCardPayment("1234-5678-9876-5432", "John Doe");
        PaymentStrategy payPal = new PayPalPayment("john.doe@example.com");

        PaymentContext context = new PaymentContext(creditCard);
        System.out.println("Using Credit Card Payment:");
        context.executePayment(150.00);

        context = new PaymentContext(payPal);
        System.out.println("\nUsing PayPal Payment:");
        context.executePayment(200.00);
    }
}
