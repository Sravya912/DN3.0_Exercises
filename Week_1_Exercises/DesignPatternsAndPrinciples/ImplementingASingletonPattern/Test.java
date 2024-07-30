package spe;

public class Test {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        System.out.println("Logger 1 instance hash: " + logger1.hashCode());
        System.out.println("Logger 2 instance hash: " + logger2.hashCode());

        logger1.log("This is a test log message.");
        logger2.log("This is another test log message.");
    }
}

