package lk.ijse.burgershopposbackend.service;

import lk.ijse.burgershopposbackend.customObj.CustomerResponse;
import lk.ijse.burgershopposbackend.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);
    void updateCustomer(CustomerDTO customerDTO);
    void deleteCustomer(String customerId);
    CustomerResponse getSelectedCustomer(String customerId);
    List<CustomerDTO> getAllCustomers();
}
