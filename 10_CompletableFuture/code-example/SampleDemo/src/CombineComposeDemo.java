import java.util.concurrent.CompletableFuture;

public class CombineComposeDemo {
    public static CompletableFuture<Integer> create(int n) {
        return CompletableFuture.supplyAsync(() -> n*n);
    }

    public static void main(String[] args) {
        create(2)
                .thenCombine(create(3), (a, b) -> a+b)
                .thenAccept(System.out::println);

        create(2)
                .thenCompose(data -> create(data))
                .thenAccept(System.out::println);
    }
}
