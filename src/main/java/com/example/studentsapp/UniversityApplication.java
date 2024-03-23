package com.example.studentsapp;

import com.example.studentsapp.entities.Product;
import com.example.studentsapp.repositoy.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class UniversityApplication implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;
    public static void main(String[] args) {
        SpringApplication.run(UniversityApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //productRepository.save(new Product(null,"Telephone",4522,2));
        //productRepository.save(new Product(null,"Pc",12362,9));
        //productRepository.save(new Product(null,"Tablette",7822,1));
        List<Product> products =productRepository.findAll();
        products.forEach(product -> {
            System.out.println(product.toString());
    });
        System.out.println("***************");
        List<Product> DebutavecT= productRepository.findByNameContains("T");
        DebutavecT.forEach(product -> {
            System.out.println(product.toString());
        });
        System.out.println("***************");
        List<Product> DebutavecT2= productRepository.search("%T%");
        DebutavecT.forEach(product -> {
            System.out.println(product.toString());
        });

}}
