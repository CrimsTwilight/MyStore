package by.crims.mystore.dto.userDTO;

import by.crims.mystore.utils.ErrorMessageManager;
import by.crims.mystore.utils.Patterns;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PasswordUserDTO {

    @NotBlank
    @Pattern(regexp = Patterns.PASSWORD, message = ErrorMessageManager.PASSWORD_USER_ERROR)
    private String password;
}
