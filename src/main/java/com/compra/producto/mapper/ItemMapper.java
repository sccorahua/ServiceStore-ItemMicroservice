package com.compra.producto.mapper;

import com.compra.producto.dto.ItemDto;
import com.compra.producto.entity.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    ItemDto toDto(Item item);
    Item toEntity(ItemDto itemDto);
    List<ItemDto> toDtoList(List<Item> items);
    List<Item> toEntityList(List<ItemDto> itemDtos);
}
