package com.lucy.musicStore.cart.mapper;

import com.lucy.musicStore.cart.dto.CartDTO;
import com.lucy.musicStore.cart.data.model.Cart;
import com.lucy.musicStore.product.music.data.dto.MusicDetailDTO;
import com.lucy.musicStore.product.music.data.model.MusicDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface CartMapper {

    @Mapping(source = "id", target = "id")
    //@Mapping(source = "unitPrice", target = "unitPrice")
    @Mapping(source = "amountPurchased", target = "amountPurchased")
    @Mapping(source = "subtotal", target = "subtotal")
    @Mapping(source = "insertCartsDate", target = "insertCartsDate")
    //@Mapping(source = "sold", target = "sold")
    CartDTO cartToCartDTO(Cart cart);

    @Mapping(source = "id", target = "id")
    //@Mapping(source = "unitPrice", target = "unitPrice")
    @Mapping(source = "amountPurchased", target = "amountPurchased")
    @Mapping(source = "subtotal", target = "subtotal")
    @Mapping(source = "insertCartsDate", target = "insertCartsDate")
    //@Mapping(source = "sold", target = "sold")
    Cart cartDTOToCart(CartDTO cartDTO);

    @Mapping(source = "artist", target = "artist")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "year", target = "year")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "genre", target = "genre")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "type", target = "type")
    MusicDetail musicDetailDTOToMusicDetail(MusicDetailDTO musicDetailDTO);
}