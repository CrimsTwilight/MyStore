package by.crims.mystore.dto.productDTO;

import by.crims.mystore.entity.CategoryOfProduct;
import by.crims.mystore.utils.ErrorMessageManager;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllArgsProductDTO {
    private CategoryOfProduct category;

    @NotBlank
    @Size(min = 2, max = 100, message = ErrorMessageManager.NAME_USER_ERROR)
    private String name;

    @NotEmpty
    @NotBlank(message = ErrorMessageManager.BLANK_FIELD_ERROR)
    private String description;

    @NotBlank
    @Size(min = 3, max = 500, message = ErrorMessageManager.PICTURE_ERROR)
    private String picture;

    private double price;
}
