public class Main {
    public static void main(String[] args) {
        Notifier standardNotifier = new EmailNotifier();
        System.out.println("--- Low Priority Alert ---");
        standardNotifier.send("System update scheduled.");

        Notifier urgentNotifier = new SMSNotifierDecorator(new EmailNotifier());
        System.out.println("\n--- High Priority Alert ---");
        urgentNotifier.send("CPU usage exceeded 90%.");

        Notifier criticalNotifier = new SlackNotifierDecorator(new SMSNotifierDecorator(new EmailNotifier()));
        System.out.println("\n--- CRITICAL ALERT ---");
        criticalNotifier.send("DATABASE CONNECTION LOST.");
    }
}