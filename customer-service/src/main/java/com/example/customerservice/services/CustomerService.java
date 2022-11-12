package com.example.customerservice.services;

import com.example.customerservice.dto.CustomerRequestDTO;
import com.example.customerservice.dto.CustomerResponseDTO;
import java.util.List;

public interface CustomerService {
     CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);
     CustomerResponseDTO getCustomer(String id);
     CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO);
     List<CustomerResponseDTO> listCustomers();

}
