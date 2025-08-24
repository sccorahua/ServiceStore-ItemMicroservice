package com.compra.producto.service;

import com.compra.producto.dto.ItemDto;
import reactor.core.publisher.Mono;

public interface ItemService {
    Mono<ItemDto> getItemById(String id);
}
