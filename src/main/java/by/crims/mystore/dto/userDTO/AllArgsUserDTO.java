package by.crims.mystore.dto.userDTO;

import by.crims.mystore.entity.Role;
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
public class AllArgsUserDTO {
    private Role role;

    @NotBlank
    @Size(min = 2, max = 30, message = ErrorMessageManager.NAME_USER_ERROR)
    private String  username;

    @NotBlank
    @Size(min = 2, max = 30, message = ErrorMessageManager.NAME_USER_ERROR)
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 30, message = ErrorMessageManager.NAME_USER_ERROR)
    private String lastName;

    @NotBlank
    @Size(min = 5, max = 100, message = ErrorMessageManager.EMAIL_USER_ERROR)
    @Pattern(regexp = Patterns.EMAIL, message = ErrorMessageManager.EMAIL_USER_ERROR)
    private String email;

    @NotBlank
    @Pattern(regexp = Patterns.PASSWORD, message = ErrorMessageManager.PASSWORD_USER_ERROR)
    private String password;

    @NotBlank
    @Size(min = 3, max = 30, message = ErrorMessageManager.SIZE_ERROR)
    private String telephone;

    @NotBlank
    @Size(min = 3, max = 500, message = ErrorMessageManager.PICTURE_ERROR)
    private String picture;
}
