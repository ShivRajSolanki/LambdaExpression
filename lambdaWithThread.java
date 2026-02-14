public class lambdaWithThread {
    public static void main(String[] args) {

        Runnable r = () -> System.out.println("Hello from Lambda!");

        Thread t = new Thread(r);
        t.start();
    }
}
