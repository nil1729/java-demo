public class Main {
    public static void main(String[] args) {
        CustomerRecords records = new CustomerRecords();

        records.addCustomer(new Customer("John"));
        records.addCustomer(new Customer("Nilanjan"));

        for(Customer next: records.getCustomers().values()) {
            System.out.println(next);
        }
        // we can obtain the reference of the collection by calling `record.getCustomers()`


        for(Customer c: records) {
            System.out.println(c);
        }
        // we can remove the iterator by calling `records.iterator().remove()`

        CustomerReadOnly john = records.getCustomerByName("John");
        System.out.println("Customer Name = " + john);
    }
}
