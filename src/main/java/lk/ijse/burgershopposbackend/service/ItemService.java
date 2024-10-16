package lk.ijse.burgershopposbackend.service;

import lk.ijse.burgershopposbackend.customObj.CustomerResponse;
import lk.ijse.burgershopposbackend.customObj.ItemResponse;
import lk.ijse.burgershopposbackend.dto.CustomerDTO;
import lk.ijse.burgershopposbackend.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    void saveItem(ItemDTO itemDTO);
    void updateItem(ItemDTO itemDTO);
    void deleteItem(String itemId);
    ItemResponse getSelectedItem(String itemId);
    List<ItemDTO> getAllItems();
}
