import java.util.concurrent.CompletableFuture;

public class MethodsDemo {
    private static void printIt(int value) {
        System.out.println(value);
    }

    private static int compute() {
        return 2;
    }

    private static CompletableFuture<Integer> create() {
        return CompletableFuture.supplyAsync(() -> compute());
    }

    public static void main(String[] args) {
        create()
                .thenApply(data -> data * 2)
                .thenApply(data -> data + 1)
                .thenAccept(data -> printIt(data))
                .thenRun(() -> System.out.println("all done"))
                .thenRun(() -> System.out.println("not really"))
                .thenRun(() -> System.out.println("keep on going"));
    }
}
