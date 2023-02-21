package com.lucy.musicStore.product.music.mapper;

import com.lucy.musicStore.product.music.data.dto.CartDTO;
import com.lucy.musicStore.product.music.data.model.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface CartMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "artist", target = "artist")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "genre", target = "genre")
    @Mapping(source = "type", target = "type")
    @Mapping(source = "unitPrice", target = "unitPrice")
    @Mapping(source = "amountSale", target = "amountSale")
    @Mapping(source = "insertCartsDate", target = "insertCartsDate")
    CartDTO cartToCartDTO(Cart cart);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "artist", target = "artist")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "genre", target = "genre")
    @Mapping(source = "type", target = "type")
    @Mapping(source = "unitPrice", target = "unitPrice")
    @Mapping(source = "amountSale", target = "amountSale")
    @Mapping(source = "insertCartsDate", target = "insertCartsDate")
    Cart cartDTOToCart(CartDTO cartDTO);
}