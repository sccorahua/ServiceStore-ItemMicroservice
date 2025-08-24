package com.compra.producto.repository;

import com.compra.producto.entity.Item;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends R2dbcRepository<Item,String> {
}
