package lk.ijse.burgershopposbackend.util;

import lk.ijse.burgershopposbackend.customObj.CustomerResponse;
import lk.ijse.burgershopposbackend.customObj.ItemResponse;
import lk.ijse.burgershopposbackend.dto.CustomerDTO;
import lk.ijse.burgershopposbackend.dto.ItemDTO;
import lk.ijse.burgershopposbackend.dto.OrderDTO;
import lk.ijse.burgershopposbackend.dto.OrderDetailsDTO;
import lk.ijse.burgershopposbackend.entity.CustomerEntity;
import lk.ijse.burgershopposbackend.entity.ItemEntity;
import lk.ijse.burgershopposbackend.entity.OrderDetailsEntity;
import lk.ijse.burgershopposbackend.entity.OrderEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;
    public CustomerResponse convertToDTO(CustomerEntity customer){
        return modelMapper.map(customer,CustomerDTO.class);
    }
    public CustomerEntity convertToEntity(CustomerDTO customerDTO){
        return modelMapper.map(customerDTO,CustomerEntity.class);

    }
    public List<CustomerDTO> convertCustomerToDTOList(List<CustomerEntity> customerEntities) {
        return modelMapper.map(customerEntities, List.class);
    }

    public ItemResponse convertToDTO(ItemEntity item){
        return modelMapper.map(item, ItemDTO.class);
    }
    public ItemEntity convertToEntity(ItemDTO itemDTO){
        return modelMapper.map(itemDTO,ItemEntity.class);

    }
    public List<ItemDTO> convertItemToDTOList(List<ItemEntity> itemEntities) {
        return modelMapper.map(itemEntities, List.class);
    }

    public OrderDTO convertOrderEntityToOrderDTO(OrderEntity orderEntity) {
        return modelMapper.map(orderEntity, OrderDTO.class);
    }

    public OrderEntity convertOrderDTOToOrderEntity(OrderDTO orderDTO) {
        return modelMapper.map(orderDTO, OrderEntity.class);
    }

    public OrderDetailsDTO convertOrderDetailsEntityToOrderDetailsDTO(OrderDetailsEntity orderDetailsEntity) {
        return modelMapper.map(orderDetailsEntity, OrderDetailsDTO.class);
    }

    public OrderDetailsEntity convertOrderDetailsDTOToOrderDetailsEntity(OrderDetailsDTO orderDetailsDTO) {
        return modelMapper.map(orderDetailsDTO, OrderDetailsEntity.class);
    }

    public List<OrderDetailsDTO> convertOrderDetailEntityListToOrderDetailDTOList(List<OrderDetailsEntity> orderDetailsEntityList) {
        return modelMapper.map(orderDetailsEntityList, new TypeToken<List<OrderDetailsDTO>>() {}.getType());
    }
}
