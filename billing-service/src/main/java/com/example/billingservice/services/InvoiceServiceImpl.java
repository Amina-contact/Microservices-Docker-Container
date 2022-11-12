package com.example.billingservice.services;

import com.example.billingservice.dto.InvoiceRequestDTO;
import com.example.billingservice.dto.InvoiceResponseDTO;
import com.example.billingservice.entities.Invoice;
import com.example.billingservice.exceptions.CustomerNotFoundException;
import com.example.billingservice.mappers.InvoiceMapper;
import com.example.billingservice.models.Customer;
import com.example.billingservice.openfeign.CustomerRESTClient;
import com.example.billingservice.repositories.InvoiceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {
    private InvoiceRepository invoiceRepository;
    private InvoiceMapper invoiceMapper;
    private CustomerRESTClient customerRESTClient;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper, CustomerRESTClient customerRESTClient) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
        this.customerRESTClient = customerRESTClient;
    }

    @Override
    public InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO) {
        Customer customer=null;
        try {
             customer = customerRESTClient.getCustomer(invoiceRequestDTO.getCustomerID());
        }
        catch (Exception e){
             throw new CustomerNotFoundException("Customer not found");
        }
        Invoice invoice=invoiceMapper.fromInvoiceRequestDTO(invoiceRequestDTO);
        invoice.setId(UUID.randomUUID().toString());
        invoice.setDate(new Date());
        //Vérification de l'intégrité référencielle

        Invoice saveInvoice=invoiceRepository.save(invoice);
        saveInvoice.setCustomer(customer);
        return invoiceMapper.fromInvoice(saveInvoice);
    }

    @Override
    public InvoiceResponseDTO getInvoice(String invoiceId)
    {
        Invoice invoice=invoiceRepository.findById(invoiceId).get();
        Customer customer=customerRESTClient.getCustomer(invoice.getCustomerID());
        invoice.setCustomer(customer);
        return invoiceMapper.fromInvoice(invoice);
    }

    @Override
    public List<InvoiceResponseDTO> invoicesByCustomerId(String customerId) {
        List<Invoice> invoices=invoiceRepository.findByCustomerID(customerId);
        for (Invoice invoice:invoices) {
            Customer customer=customerRESTClient.getCustomer(invoice.getCustomerID());
            invoice.setCustomer(customer);

        }
        return invoices
                .stream()
                .map(invoice -> invoiceMapper.fromInvoice(invoice))
                .collect(Collectors.toList());
    }

    @Override
    public List<InvoiceResponseDTO> allInvoices() {
        List<Invoice> invoices=invoiceRepository.findAll();
        for (Invoice invoice:invoices) {
            Customer customer=customerRESTClient.getCustomer(invoice.getCustomerID());
            invoice.setCustomer(customer);

        }
        return invoices
                .stream()
                .map(inv -> invoiceMapper.fromInvoice(inv))
                .collect(Collectors.toList());
    }
}
