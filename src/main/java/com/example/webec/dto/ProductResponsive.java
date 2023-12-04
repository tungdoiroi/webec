package com.example.webec.dto;

import com.example.webec.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductResponsive extends JpaRepository<Product, Long> {
}
