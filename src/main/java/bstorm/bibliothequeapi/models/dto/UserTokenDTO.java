package bstorm.bibliothequeapi.models.dto;

import bstorm.bibliothequeapi.models.entities.securities.User;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class UserTokenDTO {

    private Long id;

    private String username;

    private String role;

    private String token;

    public static UserTokenDTO fromEntity(User user,String token){
        return UserTokenDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .role(user.getRole())
                .token(token)
                .build();
    }
}
