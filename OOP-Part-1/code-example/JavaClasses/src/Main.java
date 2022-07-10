public class Main {
    public static void main(String[] args) {
        /*
         *
         * Car class
         *
         */
        Car porsche = new Car();
        Car holden = new Car();
        porsche.setModel("Carrera");
        System.out.println("Model is " + porsche.getModel());

        /*
         *
         * Account class
         *
         */
        Account bobsAccount = new Account("12345", 0.00d, "Bob Brown", "bob@email.com", "+91-93664-96119");
        System.out.println(bobsAccount.getCustomerName());
    }
}
