package by.crims.mystore.dto.userDTO;

import by.crims.mystore.utils.ErrorMessageManager;
import by.crims.mystore.utils.Patterns;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailUserDTO {

    @NotBlank
    @Size(min = 5, max = 100, message = ErrorMessageManager.EMAIL_USER_ERROR)
    @Pattern(regexp = Patterns.EMAIL, message = ErrorMessageManager.EMAIL_USER_ERROR)
    private String email;
}
