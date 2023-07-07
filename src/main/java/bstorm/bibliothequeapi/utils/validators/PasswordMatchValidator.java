package bstorm.bibliothequeapi.utils.validators;


import bstorm.bibliothequeapi.models.dto.UserRegistrationDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, UserRegistrationDTO> {

    @Override
    public void initialize(PasswordMatch constraintAnnotation) {
        // Implémentation facultative si vous avez besoin d'initialiser le validateur avec des valeurs
    }

    @Override
    public boolean isValid(UserRegistrationDTO userRegistrationDto, ConstraintValidatorContext context) {
        String password = userRegistrationDto.getPassword();
        String confirmPassword = userRegistrationDto.getConfirmPassword();

        return password != null && password.equals(confirmPassword);
    }
}



