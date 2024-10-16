package lk.ijse.burgershopposbackend.dao;


import lk.ijse.burgershopposbackend.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDAO extends JpaRepository<ItemEntity,String> {
    ItemEntity getItemEntityByItemCode(String itemCode);
}
