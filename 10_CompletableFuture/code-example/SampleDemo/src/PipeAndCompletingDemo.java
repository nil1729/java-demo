import java.util.concurrent.CompletableFuture;

public class PipeAndCompletingDemo {
    public static void process(CompletableFuture<Integer> future) {
        future
                .thenApply(data -> data*2)
                .thenApply(data -> data + 1)
                .thenAccept(System.out::println);
    }

    public static void main(String[] args) {
        CompletableFuture<Integer> cf = new CompletableFuture<>();
        process(cf);
        cf.complete(2);
    }
}
