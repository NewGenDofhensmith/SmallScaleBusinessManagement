package com.retail.retailManagement.service.Notification.retailService;

import Common.FileUtility;
import com.retail.retailManagement.dao.ProductRepository;
import com.retail.retailManagement.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

@Service
public class SchedulerService {

   @Autowired
    RetailMgmtService retailMgmtService;

   @Autowired
   EmailNotificationImpl emailNotificationImpl;

    @Autowired
    public ProductRepository productRepository;

    @Autowired
    FileUtility fileUtils;

    @Autowired
    SmsNotificationImpl sms;


   public void sendNotification(List<Product> products) throws IOException, MessagingException {
       String filePath= "classpath:/EmptyProductList.txt";
       StringBuilder data = new StringBuilder();
       for(Product tempProducts:products) {
           data.append(tempProducts.getName()+"\n");
       }

       String strinconv = data.toString();
       fileUtils.writeFile("filepath",strinconv);

       sms.sendOtp(strinconv);

      // emailNotificationImpl.sendEmail("bakiyapalani1997@gmail.com","Out of Stock Notification",strinconv);

   }
}
