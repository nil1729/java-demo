import java.util.concurrent.CompletableFuture;

public class ExceptionAndChainingDemo {
    public static int handle(Throwable throwable) {
        System.out.println("ERROR: " + throwable);
        return 100;
//        throw new RuntimeException("this is beyond any repair");
    }

    public static void process(CompletableFuture<Integer> future) {
        future
                .exceptionally(throwable -> handle(throwable))
                .thenApply(data -> data * 2)
                .thenApply(data -> data + 1)
                .thenAccept(System.out::println);
    }

    public static void main(String[] args) {
        CompletableFuture<Integer> cf = new CompletableFuture<>();
        process(cf);
        // cf.complete(2); // output: 5
        cf.completeExceptionally(new RuntimeException("something went wrong"));
    }
}
