package bstorm.bibliothequeapi.models.dto;

import bstorm.bibliothequeapi.models.entities.securities.User;
import bstorm.bibliothequeapi.utils.validators.PasswordMatch;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@PasswordMatch
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class UserRegistrationDTO {

    @NotBlank
    @NotNull
    @Length(min = 4, max = 50)
    private String username;

    @NotBlank
    @NotNull
    @Length(min = 4, max = 50)
    private String password;

    @NotBlank
    @NotNull
    @Length(min = 4, max = 50)
    private String confirmPassword;

    public User toEntity(){
        return User.builder()
                .username(this.username)
                .password(this.password)
                .build();
    }
}
