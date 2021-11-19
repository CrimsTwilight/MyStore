package by.crims.mystore.dto.cardDTO;

import by.crims.mystore.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCardDTO {
    private Product product;
}
