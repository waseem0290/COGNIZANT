public class Main {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();
        
        CustomerService service = new CustomerService(repository);
        
        service.displayCustomerInfo("101");
        service.displayCustomerInfo("102");
        service.displayCustomerInfo("999");
    }
}