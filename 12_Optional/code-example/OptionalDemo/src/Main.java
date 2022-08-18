import java.util.Optional;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        /**
         * Normal Method to handle the exception
         */
        Cat foundCat = findCatByNameMethod("john");
        if(foundCat != null) {
            System.out.println("[Type: Cat] " + foundCat.age());
        } else {
            System.out.println("NOT FOUND");
        }

        /**
         * With Optional Method
         */
        Optional<Cat> optionalCat = findCatByNameOptionalMethod("nil");

        /**
         * Noob Approach
         */
        if(optionalCat.isPresent()) {
            System.out.println("[Type: Optional<Cat>] " + optionalCat.get().age());
        } else {
            System.out.println("NOT FOUND");
        }

        /**
         * Example: we just want to print out the age (if found)
         */
        optionalCat.ifPresent(cat -> System.out.println(cat.age()));
        int foundCatAge = optionalCat.map(Cat::age).orElse(0);
        System.out.println("foundCatAge: " + foundCatAge);

        /**
         * Example: we need a cat if not found default cat
         */
        Cat exampleCatOne = optionalCat.orElse(new Cat("UNKNOWN", 0));
        System.out.println("[exampleCatOne]: " + exampleCatOne.age());

        /**
         * Example: orElseThrow and get are same
         */
        try {
            // optionalCat.get();
            optionalCat.orElseThrow();
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    public static Cat findCatByNameMethod(String name) {
        /**
         *
         * In production, we may fetch data from the database
         *
         */
        int randomInt = new Random().nextInt(0, 2);
        if(randomInt == 0) {
            return new Cat(name, 2);
        } else {
            return null;
        }
    }

    public static Optional<Cat> findCatByNameOptionalMethod(String name) {
        Cat cat = null;
        int randomInt = new Random().nextInt(0, 2);
        if(randomInt == 0) {
            cat = new Cat(name, 2);
        }

        return Optional.ofNullable(cat);
        // Optional.empty() -> If we sure that about the object is null
        // Optional.of() -> If we sure about that the object is not null
    }
}
