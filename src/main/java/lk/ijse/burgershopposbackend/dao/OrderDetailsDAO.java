package lk.ijse.burgershopposbackend.dao;


import lk.ijse.burgershopposbackend.entity.OrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsDAO extends JpaRepository<OrderDetailsEntity, String> {
}
