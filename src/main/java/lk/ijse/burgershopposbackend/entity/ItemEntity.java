package lk.ijse.burgershopposbackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table
public class ItemEntity implements SuperEntity{
    @Id
    private String itemCode;
    private String name;
    private int qty;
    private double unitPrice;
    @Column(columnDefinition = "LONGTEXT")
    private String image;
}
