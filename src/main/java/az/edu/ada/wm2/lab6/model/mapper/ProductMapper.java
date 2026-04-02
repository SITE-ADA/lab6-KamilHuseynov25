package az.edu.ada.wm2.lab6.model.mapper;

import az.edu.ada.wm2.lab6.model.Product;
import az.edu.ada.wm2.lab6.model.dto.ProductRequestDto;
import az.edu.ada.wm2.lab6.model.dto.ProductResponseDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public ProductResponseDto toResponseDto(Product product) {
        ProductResponseDto dto = new ProductResponseDto();
        dto.setId(product.getId());
        dto.setProductName(product.getProductName());
        dto.setPrice(product.getPrice());
        dto.setExpirationDate(product.getExpirationDate());
        List<String> names = product.getCategories() == null
                ? new ArrayList<>()
                : product.getCategories().stream()
                        .map(c -> c.getName())
                        .collect(Collectors.toList());
        dto.setCategoryNames(names);
        return dto;
    }

    public Product toEntity(ProductRequestDto dto) {
        return Product.builder()
                .productName(dto.getProductName())
                .price(dto.getPrice())
                .expirationDate(dto.getExpirationDate())
                .build();
    }
}
