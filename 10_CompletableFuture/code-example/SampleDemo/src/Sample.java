import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

public class Sample {
    /**
     *
     * Changing the pool
     * by default it uses common-pool
     *
     */
    public static ForkJoinPool fjp = new ForkJoinPool(10);
    public static int compute() {
        System.out.println("compute: " + Thread.currentThread());
        return 2;
    }

    public static void printIt(int value) {
        System.out.println("printIt: " + Thread.currentThread());
        System.out.println(value);
    }

    public static CompletableFuture<Integer> create() {
        return CompletableFuture.supplyAsync(() -> compute(), fjp);
    }

    public static void main(String[] args) {
        System.out.println("main: " + Thread.currentThread());
        CompletableFuture<Integer> cf = create();

        sleep(1000);

        create()
                .thenAccept(data -> printIt(data));

        sleep(1000);
    }

    private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {
        }
    }
}
