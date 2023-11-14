package christmas.repository;

import christmas.domain.Customer;
import java.util.HashMap;
import java.util.Map;

public class CustomerRepository {

    private static Map<Long, Customer> customers;

    public CustomerRepository() {
        this.customers = new HashMap<>();
    }

    public void save(Customer customer) {
        Long customerId = customer.getId();
        customers.put(customerId, customer);
    }
}
