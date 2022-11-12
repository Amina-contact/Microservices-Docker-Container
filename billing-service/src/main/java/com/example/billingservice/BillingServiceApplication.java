package com.example.billingservice;

import com.example.billingservice.dto.InvoiceRequestDTO;
import com.example.billingservice.services.InvoiceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(InvoiceService invoiceService){
        return args -> {
            invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(76000),"A01"));
            invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(34000),"A01"));
            invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(54000),"A02"));
        };
    }
}
