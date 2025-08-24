package com.compra.producto.controller;

import com.compra.producto.dto.ItemDto;
import com.compra.producto.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/item")
@AllArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/{idItem}")
    public Mono<ResponseEntity<ItemDto>> getItemById(@PathVariable String idItem) {
        return itemService.getItemById(idItem)
                .map(itemDto -> ResponseEntity.ok().body(itemDto))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

}
