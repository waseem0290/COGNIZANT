public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void displayCustomerInfo(String id) {
        Customer customer = customerRepository.findCustomerById(id);
        if (customer != null) {
            System.out.println("Customer ID: " + customer.getId() + ", Name: " + customer.getName());
        } else {
            System.out.println("Customer not found for ID: " + id);
        }
    }
}