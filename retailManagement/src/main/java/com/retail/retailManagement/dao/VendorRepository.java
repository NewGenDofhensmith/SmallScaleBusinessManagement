package com.retail.retailManagement.dao;

import com.retail.retailManagement.entity.Product;
import com.retail.retailManagement.entity.Vendors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@CrossOrigin("http://localhost:4200")
public interface VendorRepository extends JpaRepository<Vendors, Long> {
}
