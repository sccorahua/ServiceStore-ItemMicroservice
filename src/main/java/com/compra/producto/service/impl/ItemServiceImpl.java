package com.compra.producto.service.impl;

import com.compra.producto.dto.ItemDto;
import com.compra.producto.mapper.ItemMapper;
import com.compra.producto.repository.ItemRepository;
import com.compra.producto.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    @Override
    public Mono<ItemDto> getItemById(String id) {
        return itemRepository.findById(id)
                .map(itemMapper::toDto);
    }
}
