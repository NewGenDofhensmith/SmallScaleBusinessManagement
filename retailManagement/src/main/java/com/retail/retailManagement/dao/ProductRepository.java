package com.retail.retailManagement.dao;

import com.retail.retailManagement.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Long> {
    //http://localhost:8080/api/products/search/findByCategoryId{?id,page,size,sort}
    Page<Product> findByCategoryId(@Param("id") Long id, Pageable pageable);

    Page<Product> findByNameContaining(@Param("name") String name, Pageable pageable);
     //"SELECT COUNT(*) FROM products WHERE units_in_stock = 0"
    int countByUnitsInStock(int quantity);
    //"SELECT * FROM products WHERE units_in_stock = 0"
    List<Product> findByUnitsInStock(int id);
}
