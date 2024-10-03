package com.retail.retailManagement.Controller;

import com.retail.retailManagement.dao.ProductRepository;
import com.retail.retailManagement.entity.Product;
import com.retail.retailManagement.service.Notification.retailService.RetailMgmtService;
import com.retail.retailManagement.service.Notification.retailService.SchedulerService;
import org.kie.api.runtime.KieContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RuleController {

    @Autowired
    SchedulerService scheduler;

    @Autowired
    RetailMgmtService retailMgmtService;

    @Autowired
    public ProductRepository productRepository;

    @GetMapping("/SchedulerService")
    public ResponseEntity<String> scheduler(HttpServletRequest request) throws IOException, MessagingException {

        //List<Product> products=retailMgmtService.getProductsByUnitsInStock(0);

        List<Product> emptyproducts= new ArrayList<Product>();

        //Stock Empty send Notification
        if(!retailMgmtService.getProductsByUnitsInStock(0).isEmpty()) {
            emptyproducts = retailMgmtService.getProductsByUnitsInStock(0);
            scheduler.sendNotification(emptyproducts);
        }

        //Fire all rules
        //retailMgmtService.fireAllRules(productRepository.findAll());

        //generateExcel(emptyproducts,)
        String myData ="<html><h1>Success</h1></html>";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_HTML);
        return new ResponseEntity<>(myData, headers, HttpStatus.OK);
    }
}
