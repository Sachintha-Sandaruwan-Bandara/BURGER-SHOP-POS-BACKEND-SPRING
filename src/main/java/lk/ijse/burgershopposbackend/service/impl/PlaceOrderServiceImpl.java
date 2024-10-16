package lk.ijse.burgershopposbackend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.burgershopposbackend.dao.OrderDAO;
import lk.ijse.burgershopposbackend.dao.OrderDetailsDAO;
import lk.ijse.burgershopposbackend.dto.OrderDTO;
import lk.ijse.burgershopposbackend.dto.OrderDetailsDTO;
import lk.ijse.burgershopposbackend.entity.OrderDetailsEntity;
import lk.ijse.burgershopposbackend.entity.OrderEntity;
import lk.ijse.burgershopposbackend.exception.DataPersistFailedException;
import lk.ijse.burgershopposbackend.service.PlaceOrderService;

import lk.ijse.burgershopposbackend.util.AppUtil;
import lk.ijse.burgershopposbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PlaceOrderServiceImpl implements PlaceOrderService {

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private OrderDetailsDAO orderDetailsDAO;

    @Autowired
    private Mapping mapping;

    @Override
    public void saveOrder(OrderDTO orderDTO) {

        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setOId(AppUtil.createOrderId());
        orderEntity.setDate(orderDTO.getDate());
        orderEntity.setTotal(orderDTO.getTotal());
        orderEntity.setCustomerId(orderDTO.getCustomerId());

        OrderEntity save = orderDAO.save(orderEntity);

        List<OrderDetailsDTO> orderDetailsDTOS = orderDTO.getOrderDetails();

        for(OrderDetailsDTO orderDetailsDTO : orderDetailsDTOS) {

            OrderDetailsEntity orderDetailsEntity = new OrderDetailsEntity();

            orderDetailsEntity.setItemId(orderDetailsDTO.getItemId());
            orderDetailsEntity.setItemName(orderDetailsDTO.getItemName());
            orderDetailsEntity.setItemDescription(orderDetailsDTO.getItemDescription());
            orderDetailsEntity.setQty(orderDetailsDTO.getQty());
            orderDetailsEntity.setUnitPrice(orderDetailsDTO.getUnitPrice());
            orderDetailsEntity.setTotal(orderDetailsDTO.getTotal());

            orderDetailsDAO.save(orderDetailsEntity);
        }

        if(save == null){
            throw  new DataPersistFailedException("order save failed");
        }


    }

    @Override
    public List<OrderDetailsDTO> getOrderDetails() {
        return mapping.convertOrderDetailEntityListToOrderDetailDTOList(orderDetailsDAO.findAll());
    }
}
