package com.compra.producto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("item")
public class Item {
    @Id
    @Column(value = "item_id")
    private String itemId;
    @Column(value = "item_name")
    private String itemName;
    @Column(value = "stock")
    private Integer stock;
    @Column(value = "item_description")
    private String itemDescription;
    @Column(value = "price")
    private BigDecimal price;
}
