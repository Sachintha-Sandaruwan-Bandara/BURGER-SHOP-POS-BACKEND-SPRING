package lk.ijse.burgershopposbackend.dao;


import lk.ijse.burgershopposbackend.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDAO extends JpaRepository<CustomerEntity,String> {
    CustomerEntity getCustomerEntitiesByCustomerId (String customerId);
}
