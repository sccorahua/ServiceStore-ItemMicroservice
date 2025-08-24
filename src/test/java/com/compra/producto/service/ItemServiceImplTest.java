package com.compra.producto.service;

import com.compra.producto.dto.ItemDto;
import com.compra.producto.entity.Item;
import com.compra.producto.mapper.ItemMapper;
import com.compra.producto.repository.ItemRepository;
import com.compra.producto.service.impl.ItemServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
public class ItemServiceImplTest {

    @Mock
    private ItemRepository itemRepository;

    @Mock
    private ItemMapper itemMapper;

    @InjectMocks
    private ItemServiceImpl itemService;

    private Item item;
    private ItemDto itemDto;

    @BeforeEach
    public void setUp() {
        item = new Item();
        item.setItemId("PR50");
        item.setItemName("Cinta Adhesiva");
        item.setPrice(BigDecimal.valueOf(3.50));

        itemDto = new ItemDto();
        itemDto.setItemId("PR50");
        itemDto.setItemName("Cinta Adhesiva");
        itemDto.setPrice(BigDecimal.valueOf(3.50));
    }

    @Test
    void getItemById_existItems() {
        Mockito.when(itemRepository.findById("PR50")).thenReturn(Mono.just(item));
        Mockito.when(itemMapper.toDto(item)).thenReturn(itemDto);

        StepVerifier.create(itemService.getItemById("PR50"))
                .expectNextMatches(dto ->
                        dto.getItemId().equals("PR50") &&
                                dto.getItemName().equals("Cinta Adhesiva") &&
                                dto.getPrice().compareTo(BigDecimal.valueOf(3.50)) == 0
                )
                .verifyComplete();
    }

    @Test
    void getItemById_notExistItems() {
        Mockito.when(itemRepository.findById("PR50")).thenReturn(Mono.empty());

        StepVerifier.create(itemService.getItemById("PR50"))
                .expectNextCount(0)
                .verifyComplete();
    }
}
