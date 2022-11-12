package com.example.billingservice.web;

import com.example.billingservice.dto.InvoiceRequestDTO;
import com.example.billingservice.dto.InvoiceResponseDTO;
import com.example.billingservice.exceptions.CustomerNotFoundException;
import com.example.billingservice.services.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class InvoiceRestController {
    private InvoiceService invoiceService;

    public InvoiceRestController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }
    @GetMapping(path = "/invoices/{id}")
    public InvoiceResponseDTO getInvoice(@PathVariable(name = "id") String invoiceId){
        return invoiceService.getInvoice(invoiceId);
    }
    @GetMapping(path = "/invoicesByCustomer/{customerID}")
    public List<InvoiceResponseDTO> getInvoicesByCustomer(@PathVariable String customerID){
        return invoiceService.invoicesByCustomerId(customerID);
    }
    @PostMapping(path = "/invoices")
    public InvoiceResponseDTO save(@RequestBody InvoiceRequestDTO invoiceRequestDTO){
           return invoiceService.save(invoiceRequestDTO);
    }
    @GetMapping(path = "/invoices")
    public List<InvoiceResponseDTO> allInvoices(){
        return invoiceService.allInvoices();
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception e){
       return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
