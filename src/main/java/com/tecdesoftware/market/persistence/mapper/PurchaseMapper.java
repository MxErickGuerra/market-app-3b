package com.tecdesoftware.market.persistence.mapper;

import com.tecdesoftware.market.domain.Purchase;
import com.tecdesoftware.market.persistence.entity.Compra;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {

    @Mappings({
            @Mapping(target = "purchaseId", source = "idCompra"), // Usamos idCompra directamente
            @Mapping(target = "clientId", source = "idCliente", qualifiedByName = "integerToString"),
            @Mapping(target = "date", source = "fecha"),
            @Mapping(target = "comment", source = "comentario"),
            @Mapping(target = "state", source = "estado", qualifiedByName = "booleanToString"),
            @Mapping(target = "item", source = "productos")
    })
    Purchase toPurchase(Compra compra);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "idCompra", source = "purchaseId"), // Usamos idCompra directamente
            @Mapping(target = "idCliente", source = "clientId", qualifiedByName = "stringToInteger"),
            @Mapping(target = "fecha", source = "date"),
            @Mapping(target = "comentario", source = "comment"),
            @Mapping(target = "estado", source = "state", qualifiedByName = "stringToBoolean"),
            @Mapping(target = "productos", source = "item"),
            @Mapping(target = "cliente", ignore = true),
            @Mapping(target = "medioPago", ignore = true)
    })
    Compra toCompra(Purchase purchase);

    List<Purchase> toPurchases(List<Compra> compras);

    /* Métodos de conversión personalizados */
    @Named("integerToString")
    default String integerToString(Integer value) {
        return value != null ? value.toString() : null;
    }

    @Named("stringToInteger")
    default Integer stringToInteger(String value) {
        try {
            return value != null ? Integer.parseInt(value) : null;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Named("booleanToString")
    default String booleanToString(Boolean value) {
        return value != null ? value.toString() : null;
    }

    @Named("stringToBoolean")
    default Boolean stringToBoolean(String value) {
        return value != null ? Boolean.parseBoolean(value) : null;
    }
}