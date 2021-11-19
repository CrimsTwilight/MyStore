package by.crims.mystore.dto.productDTO;

import by.crims.mystore.utils.ErrorMessageManager;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DescriptionProductDTO {
    private long id;

    @NotEmpty
    @NotBlank(message = ErrorMessageManager.BLANK_FIELD_ERROR)
    private String description;
}
