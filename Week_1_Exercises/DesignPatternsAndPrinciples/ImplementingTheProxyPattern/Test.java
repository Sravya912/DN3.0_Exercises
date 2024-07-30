package proxy;

public class Test {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");

        // Image will be loaded and displayed from the remote server
        image1.display();

        // Image is already loaded, so it will be displayed from cache
        image1.display();

        // Image will be loaded and displayed from the remote server
        image2.display();
    }
}
