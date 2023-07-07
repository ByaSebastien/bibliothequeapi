package bstorm.bibliothequeapi.services;

import bstorm.bibliothequeapi.models.entities.Book;
import bstorm.bibliothequeapi.models.forms.BookForm;
import bstorm.bibliothequeapi.repositories.BookRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }
    @Override
    public Book getById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if(book.isEmpty()){
            throw new NotFoundException("Le livre que vous cherchez n'existe pas.");
        }
        return book.get();
    }

    @Override
    public void insert(BookForm b) {
        bookRepository.save(b.toEntity());
    }
}
