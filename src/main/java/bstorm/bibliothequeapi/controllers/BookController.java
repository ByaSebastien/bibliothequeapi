package bstorm.bibliothequeapi.controllers;

import bstorm.bibliothequeapi.models.entities.Book;
import bstorm.bibliothequeapi.models.forms.BookForm;
import bstorm.bibliothequeapi.services.BookService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable("id") Long id){

        Book book = bookService.getById(id);
        return ResponseEntity.ok(book);
    }

    @PostMapping
    public ResponseEntity<String> insert(@Valid @RequestBody BookForm b){
        bookService.insert(b);
        return ResponseEntity.ok("Livre ajouté");
    }

}
