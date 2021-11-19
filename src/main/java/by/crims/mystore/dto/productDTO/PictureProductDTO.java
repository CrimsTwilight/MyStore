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
public class PictureProductDTO {
    private long id;

    @NotBlank
    @Size(min = 3, max = 500, message = ErrorMessageManager.PICTURE_ERROR)
    private String picture;
}
