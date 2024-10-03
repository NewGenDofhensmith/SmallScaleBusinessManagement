package com.retail.retailManagement.service.Notification.retailService;

import com.retail.retailManagement.dao.ProductCategoryRepository;
import com.retail.retailManagement.dao.ProductRepository;
import com.retail.retailManagement.entity.Product;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RetailMgmtService {

    @Autowired
    public ProductRepository productRepository;

    @Autowired
    public ProductCategoryRepository productCategoryRepository;

    @Autowired
    private KieContainer kieContainer;

    public void  fireAllRules(List<Product> product) {
        KieSession kieSession = kieContainer.newKieSession("ksession-rules");
        for(Product p:product)
              kieSession.insert(p);
        kieSession.fireAllRules();
        kieSession.dispose();
    }

    public List<Product> getProductsByUnitsInStock(int id) {
        return  productRepository.findByUnitsInStock(id);
    }

}
