package lk.ijse.burgershopposbackend.service.impl;
/* 
    @author 
      
 (                           )   (        (                            )   (                 (               
 )\ )     (         (     ( /(   )\ )     )\ )       (      (       ( /(   )\ )      (       )\ )     (      
(()/(     )\        )\    )\()) (()/(    (()/(     ( )\     )\      )\()) (()/(      )\     (()/(     )\     
 /(_)) ((((_)(    (((_)  ((_)\   /(_))    /(_))    )((_) ((((_)(   ((_)\   /(_))  ((((_)(    /(_)) ((((_)(   
(_))    )\ _ )\   )\___   _((_) (_))     (_))     ((_)_   )\ _ )\   _((_) (_))_    )\ _ )\  (_))    )\ _ )\  
/ __|   (_)_\(_) ((/ __| | || | |_ _|    / __|     | _ )  (_)_\(_) | \| |  |   \   (_)_\(_) | _ \   (_)_\(_) 
\__ \    / _ \    | (__  | __ |  | |     \__ \     | _ \   / _ \   | .` |  | |) |   / _ \   |   /    / _ \   
|___/   /_/ \_\    \___| |_||_| |___|    |___/     |___/  /_/ \_\  |_|\_|  |___/   /_/ \_\  |_|_\   /_/ \_\  
  
 @created 10/16/2024 - 2:52 PM 
*/

import jakarta.transaction.Transactional;
import lk.ijse.burgershopposbackend.customObj.CustomerErrorResponse;
import lk.ijse.burgershopposbackend.customObj.CustomerResponse;
import lk.ijse.burgershopposbackend.customObj.ItemErrorResponse;
import lk.ijse.burgershopposbackend.customObj.ItemResponse;
import lk.ijse.burgershopposbackend.dao.CustomerDAO;
import lk.ijse.burgershopposbackend.dao.ItemDAO;
import lk.ijse.burgershopposbackend.dto.CustomerDTO;
import lk.ijse.burgershopposbackend.dto.ItemDTO;
import lk.ijse.burgershopposbackend.entity.CustomerEntity;
import lk.ijse.burgershopposbackend.entity.ItemEntity;
import lk.ijse.burgershopposbackend.exception.CustomerNotFoundException;
import lk.ijse.burgershopposbackend.exception.DataPersistFailedException;
import lk.ijse.burgershopposbackend.service.ItemService;
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
public class ItemServiceImpl implements ItemService {
    @Autowired
    private final ItemDAO itemDAO;

    @Autowired
    private final Mapping mapping;

    @Override
    public void saveItem(ItemDTO itemDTO) {
        itemDTO.setItemCode(AppUtil.createItemCode());
        ItemEntity saveItem=
                itemDAO.save(mapping.convertToEntity(itemDTO));
        if(saveItem == null && saveItem.getItemCode() == null ) {
            throw new DataPersistFailedException("Cannot data saved");
        }
    }



    @Override
    public void deleteItem(String itemCode) {
        Optional<ItemEntity> selectedItemCode = itemDAO.findById(itemCode);
        if (!selectedItemCode.isPresent()) {
            throw new CustomerNotFoundException("User not found");
        } else {
            itemDAO.deleteById(itemCode);
        }
    }

    @Override
    public ItemResponse getSelectedItem(String itemCode) {

        if (itemDAO.existsById(itemCode)) {
            ItemEntity itemEntityByItemCode = itemDAO.getItemEntityByItemCode(itemCode);
            return mapping.convertToDTO(itemEntityByItemCode);
        }else {
            return new ItemErrorResponse(0,"item Not Found");
        }    }

    @Override
    public List<ItemDTO> getAllItems() {

        return mapping.convertItemToDTOList(itemDAO.findAll());
    }

    @Override
    public void updateItem( ItemDTO itemDTO) {
        Optional<ItemEntity> tempItem = itemDAO.findById(itemDTO.getItemCode());
        if (!tempItem.isPresent()) {

            throw new CustomerNotFoundException("item Not Found");



        } else {

            tempItem.get().setName(itemDTO.getName());
            tempItem.get().setQty(itemDTO.getQty());
            tempItem.get().setUnitPrice(itemDTO.getUnitPrice());
            tempItem.get().setImage(itemDTO.getImage());

        }
    }

}
