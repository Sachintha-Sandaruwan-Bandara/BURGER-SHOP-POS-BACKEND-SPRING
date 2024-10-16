package lk.ijse.burgershopposbackend.service.impl;


import jakarta.transaction.Transactional;
import lk.ijse.burgershopposbackend.customObj.CustomerErrorResponse;
import lk.ijse.burgershopposbackend.customObj.CustomerResponse;
import lk.ijse.burgershopposbackend.dao.CustomerDAO;
import lk.ijse.burgershopposbackend.dto.CustomerDTO;
import lk.ijse.burgershopposbackend.entity.CustomerEntity;
import lk.ijse.burgershopposbackend.exception.CustomerNotFoundException;
import lk.ijse.burgershopposbackend.exception.DataPersistFailedException;
import lk.ijse.burgershopposbackend.service.CustomerService;
import lk.ijse.burgershopposbackend.util.AppUtil;
import lk.ijse.burgershopposbackend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private final CustomerDAO customerDAO;

    @Autowired
    private final Mapping mapping;

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        customerDTO.setCustomerId(AppUtil.createCustomerId());
        CustomerEntity saveCustomer=
                customerDAO.save(mapping.convertToEntity(customerDTO));
        if(saveCustomer == null && saveCustomer.getCustomerId() == null ) {
            throw new DataPersistFailedException("Cannot data saved");
        }
    }



    @Override
    public void deleteCustomer(String customerId) {
        Optional<CustomerEntity> selectedCustomerId = customerDAO.findById(customerId);
        if (!selectedCustomerId.isPresent()) {
            throw new CustomerNotFoundException("User not found");
        } else {
            customerDAO.deleteById(customerId);
        }
    }

    @Override
    public CustomerResponse getSelectedCustomer(String customerId) {

        if (customerDAO.existsById(customerId)) {
            CustomerEntity customerEntityByCustomerId = customerDAO.getCustomerEntitiesByCustomerId(customerId);
            return mapping.convertToDTO(customerEntityByCustomerId);
        }else {
            return new CustomerErrorResponse(0,"User Not Found");
        }    }

    @Override
    public List<CustomerDTO> getAllCustomers() {

        return mapping.convertCustomerToDTOList(customerDAO.findAll());
    }

    @Override
    public void updateCustomer( CustomerDTO customerDTO) {
        Optional<CustomerEntity> tempCustomer = customerDAO.findById(customerDTO.getCustomerId());
        if (!tempCustomer.isPresent()) {

            throw new CustomerNotFoundException("User Not Found");



        } else {

            tempCustomer.get().setName(customerDTO.getName());
            tempCustomer.get().setAddress(customerDTO.getAddress());
            tempCustomer.get().setSalary(customerDTO.getSalary());
            tempCustomer.get().setProfilePic(customerDTO.getProfilePic());

        }
    }

}
