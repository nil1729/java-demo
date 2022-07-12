public class Customer {
    private int id;
    private String name;

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer(" +
                "id= " + id +
                ", name= " + name + ")";
    }

    public Customer(String name) {
        this.name = name;
    }
}
