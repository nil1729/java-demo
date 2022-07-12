import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CustomerRecords implements Iterable<Customer> {
    private Map<String, Customer> records;

    public CustomerRecords() {
        this.records = new HashMap<String, Customer>();
    }

    public void addCustomer(Customer c) {
        records.put(c.getName(), c);
    }

    public Map<String, Customer> getCustomers() {
        // return this.records; // this method return the reference of the collection
        // return new HashMap<String, Customer>(this.records); // Duplicating collections
        return Collections.unmodifiableMap(this.records);
        // after that we can't call `record.getCustomers().clear()` on main method.
        // This will throw UnsupportedOperationException
    }

    @Override
    public Iterator iterator() {
        return this.records.values().iterator();
    }

    // public Customer getCustomerByName(String name) {
        // return new Customer(this.records.get(name));
        // we have to create a copy
    // }

    public CustomerReadOnly getCustomerByName(String name) {
        return this.records.get(name);
    }
}
