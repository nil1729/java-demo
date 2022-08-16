import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class TimeoutDemo {
    private static void process(CompletableFuture<Integer> future) {
        future
                .thenApply(data -> data * 2)
                .thenApply(data -> data + 1)
                .thenAccept(System.out::println);
    }

    public static void main(String[] args) {
        CompletableFuture<Integer> cf = new CompletableFuture<>();
        cf.completeOnTimeout(500, 3, TimeUnit.SECONDS);
//        cf.orTimeout(3, TimeUnit.SECONDS);
        process(cf);

        sleep(2000);
        cf.complete(2);
        sleep(5000);
    }

    private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {}
    }
}
