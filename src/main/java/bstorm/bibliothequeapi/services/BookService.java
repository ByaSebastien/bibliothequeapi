package bstorm.bibliothequeapi.services;

import bstorm.bibliothequeapi.models.dto.UserLoginDTO;
import bstorm.bibliothequeapi.models.dto.UserRegistrationDTO;
import bstorm.bibliothequeapi.models.dto.UserTokenDTO;
import bstorm.bibliothequeapi.models.entities.Book;
import bstorm.bibliothequeapi.models.forms.BookForm;
import bstorm.bibliothequeapi.repositories.securities.UserRepository;
import org.springframework.stereotype.Service;

@Service
public interface BookService {

    Book getById(Long id);

    void insert(BookForm b);

}
