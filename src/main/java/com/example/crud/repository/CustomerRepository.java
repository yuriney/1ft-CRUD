package com.example.crud.repository;
import java.util.List;
import com.example.crud.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}