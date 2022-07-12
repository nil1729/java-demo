public class Customer implements CustomerReadOnly {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    // Duplicating the Customer Object
    public Customer(Customer oldCustomer) {
        this.name = oldCustomer.getName();
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
