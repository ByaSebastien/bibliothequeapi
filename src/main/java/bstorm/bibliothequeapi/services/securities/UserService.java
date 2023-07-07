package bstorm.bibliothequeapi.services.securities;

import bstorm.bibliothequeapi.models.dto.UserLoginDTO;
import bstorm.bibliothequeapi.models.dto.UserRegistrationDTO;
import bstorm.bibliothequeapi.models.dto.UserTokenDTO;
import bstorm.bibliothequeapi.models.entities.securities.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User register(User dto);

    User login(User login);
}
