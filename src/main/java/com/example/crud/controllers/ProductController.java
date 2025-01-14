package com.example.crud.controllers;

import com.example.crud.domain.product.Product;
import com.example.crud.domain.product.ProductRepository;
import com.example.crud.domain.product.RequestProductDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    // GET: Fetch all products
    @GetMapping
    public ResponseEntity getAllProducts() {
        var allProducts = repository.findAll();
        return ResponseEntity.ok(allProducts);
    }

    // POST: Register a new product
    @PostMapping
    public ResponseEntity registerProduct(@RequestBody @Valid RequestProductDTO data) {
        Product newProduct = new Product(data);
        repository.save(newProduct);
        return ResponseEntity.ok(newProduct);
    }

    // PUT: Update an existing product by ID
    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable String id, @RequestBody @Valid RequestProductDTO data) {
        Optional<Product> optionalProduct = repository.findById(id);

        if (optionalProduct.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Product product = optionalProduct.get();
        product.setName(data.name());
        product.setPrice_in_cents(data.price_in_cents());
        repository.save(product);
        return ResponseEntity.ok(product);
    }

    // DELETE: Remove a product by ID
    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable String id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
