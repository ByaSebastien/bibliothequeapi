package bstorm.bibliothequeapi.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordUtils {

    private final BCryptPasswordEncoder passwordEncoder;

    public PasswordUtils(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.passwordEncoder = bCryptPasswordEncoder;
    }

    public String hashPassword(String password){
        return passwordEncoder.encode(password);
    }

    public boolean verifyPassword(String password,String hashedPassword){
        return passwordEncoder.matches(password,hashedPassword);
    }
}
