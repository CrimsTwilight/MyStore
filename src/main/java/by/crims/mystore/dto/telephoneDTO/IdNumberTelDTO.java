package by.crims.mystore.dto.telephoneDTO;

import by.crims.mystore.utils.ErrorMessageManager;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IdNumberTelDTO {
    private long id;

    @NotBlank
    @Size(min = 3, max = 30, message = ErrorMessageManager.SIZE_ERROR)
    private String telephone;
}
