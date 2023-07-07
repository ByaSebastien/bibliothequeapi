package bstorm.bibliothequeapi.models.dto;

import bstorm.bibliothequeapi.models.entities.securities.User;
import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class UserLoginDTO {

    private String username;

    private String password;

    public User toEntity(){
        return User.builder()
                .username(this.username)
                .password(this.password)
                .build();
    }
}
