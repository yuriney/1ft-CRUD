package com.example.crud.service;

import com.example.crud.entity.Customer;
import com.example.crud.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer findCustomerById(Long id){
        return customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + id));
    }

    public void updateCustomerById(Long id, Customer customerNewData){
        Customer customerBdData = findCustomerById(id);
        customerBdData.setFirstName(customerNewData.getFirstName());
        customerBdData.setLastName(customerNewData.getLastName());
        customerRepository.save(customerBdData);
    }

    public void deleteCustomerById(Long id){
        customerRepository.deleteById(id);
    }
}
