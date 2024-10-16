package lk.ijse.burgershopposbackend.service;



import lk.ijse.burgershopposbackend.dto.OrderDTO;
import lk.ijse.burgershopposbackend.dto.OrderDetailsDTO;

import java.util.List;

public interface PlaceOrderService {
    void saveOrder(OrderDTO orderDTO);

    List<OrderDetailsDTO> getOrderDetails();
}
