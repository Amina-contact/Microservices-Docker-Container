package com.example.customerservice.mappers;

import com.example.customerservice.dto.CustomerRequestDTO;
import com.example.customerservice.dto.CustomerResponseDTO;
import com.example.customerservice.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDTO customerToCustomerResponseDTO(Customer customer);
    Customer CustomerRequestDTOTocustomer(CustomerRequestDTO customerRequestDTO);
}
