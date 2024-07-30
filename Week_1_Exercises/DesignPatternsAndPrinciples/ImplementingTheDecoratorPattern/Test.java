package decorator;

public class Test {
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier();

        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);
        Notifier slackNotifier = new SlackNotifierDecorator(emailNotifier);

        System.out.println("Sending notification via SMS:");
        smsNotifier.send("Hello World!");

        System.out.println("\nSending notification via Slack:");
        slackNotifier.send("Hello World!");

        System.out.println("\nSending notification via SMS and Slack:");
        Notifier combinedNotifier = new SlackNotifierDecorator(smsNotifier);
        combinedNotifier.send("Hello World!");
    }
}
