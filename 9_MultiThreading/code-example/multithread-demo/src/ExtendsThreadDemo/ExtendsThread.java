package ExtendsThreadDemo;

class Hi extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("ExtendsThreadDemo.Hi");

            // Suspending the Thread
            try {
                Thread.sleep(500);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}

class Hello extends Thread{
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("ExtendsThreadDemo.Hello");

            // Suspending the Thread
            try {
                Thread.sleep(500);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}

public class ExtendsThread {
    public static void main(String[] args) {
        Hi obj1 = new Hi();
        Hello obj2 = new Hello();

        // when call `start` method it is internally execute the `run` method
        obj1.start();

        try {
            Thread.sleep(100);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        obj2.start();

        //obj1.run(); // 5 times "ExtendsThreadDemo.Hi Java"
        //obj2.run(); // 5 times "ExtendsThreadDemo.Hello Java" after "ExtendsThreadDemo.Hi Java"
    }
}
