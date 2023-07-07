package bstorm.bibliothequeapi.services.securities;

import bstorm.bibliothequeapi.models.dto.UserLoginDTO;
import bstorm.bibliothequeapi.models.dto.UserTokenDTO;
import bstorm.bibliothequeapi.models.entities.securities.User;
import bstorm.bibliothequeapi.repositories.securities.UserRepository;
import bstorm.bibliothequeapi.utils.JwtUtil;
import bstorm.bibliothequeapi.utils.PasswordUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    private final JwtUtil jwtUtil;

    private final PasswordUtils passwordUtils;

    public UserServiceImpl(UserRepository userRepository, JwtUtil jwtUtil, PasswordUtils passwordUtils) {

        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.passwordUtils = passwordUtils;
    }

    @Override
    public User register(User user) {

        if(userRepository.existsByUsername(user.getUsername()))
            throw new RuntimeException("Username already exist");
        String hashedPassword = passwordUtils.hashPassword(user.getPassword());
        user.setPassword(hashedPassword);
        user.setRole("user");

        return userRepository.save(user);
    }

    @Override
    public User login(User login) {

        User user = userRepository.findByUsername(login.getUsername());
        if(user == null)
            throw new RuntimeException("User doesn't exist");
        if(!passwordUtils.verifyPassword(login.getPassword(), user.getPassword()))
            throw new RuntimeException("Wrong password");
        return user;
    }
}
