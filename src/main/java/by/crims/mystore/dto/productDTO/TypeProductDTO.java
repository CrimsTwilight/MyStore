package by.crims.mystore.dto.productDTO;

import by.crims.mystore.entity.CategoryOfProduct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeProductDTO {
    private long id;
    private CategoryOfProduct category;
}
