public class Main {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("nature_background.png");
        Image image2 = new ProxyImage("user_avatar.jpg");

        System.out.println("--- User clicks on image 1 ---");
        image1.display();

        System.out.println("\n--- User clicks on image 1 again ---");
        image1.display();

        System.out.println("\n--- User clicks on image 2 ---");
        image2.display();
    }
}