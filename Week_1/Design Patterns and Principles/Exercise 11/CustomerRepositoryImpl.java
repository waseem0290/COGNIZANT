import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository {
    private Map<String, Customer> database;

    public CustomerRepositoryImpl() {
        database = new HashMap<>();
        database.put("101", new Customer("101", "John Doe"));
        database.put("102", new Customer("102", "Jane Smith"));
    }

    @Override
    public Customer findCustomerById(String id) {
        return database.get(id);
    }
}