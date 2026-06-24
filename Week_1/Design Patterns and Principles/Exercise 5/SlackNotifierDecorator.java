public class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier wrapper) {
        super(wrapper);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending Slack Message: " + message);
    }
}