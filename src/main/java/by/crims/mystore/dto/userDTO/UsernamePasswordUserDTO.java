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
public class UsernamePasswordUserDTO {

    @NotBlank
    @Size(min = 2, max = 30, message = ErrorMessageManager.NAME_USER_ERROR)
    private String  username;

    @NotBlank
    @Pattern(regexp = Patterns.PASSWORD, message = ErrorMessageManager.PASSWORD_USER_ERROR)
    private String password;
}
