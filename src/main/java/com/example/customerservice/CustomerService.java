package com.example.customerservice;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class CustomerService {
    public List<Customer> findByName(String name) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setType(CustomerType.BUSINESS);
        customer.setRevenue(10000);
        customer.setTest(BigDecimal.ZERO);
        customer.setBirthDate(LocalDate.of(2000, 1,1));
        return Collections.singletonList(customer);
    }
}
