package com.compra.producto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
    private String itemId;
    private String itemName;
    private Integer stock;
    private String itemDescription;
    private BigDecimal price;
}
