package by.crims.mystore.dto.productDTO;

import by.crims.mystore.utils.ErrorMessageManager;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NameProductDTO {
    private long id;

    @NotBlank
    @Size(min = 2, max = 100, message = ErrorMessageManager.NAME_USER_ERROR)
    private String name;
}
