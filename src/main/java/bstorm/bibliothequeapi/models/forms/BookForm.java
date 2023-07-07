package bstorm.bibliothequeapi.models.forms;

import bstorm.bibliothequeapi.models.entities.Book;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class BookForm {

    @NotBlank
    private String isbn;

    @NotBlank
    private String title;

    private String description;

    public Book toEntity(){
        Book book = new Book();
        book.setIsbn(this.isbn);
        book.setTitle(this.title);
        book.setDescription(this.description);
        return book;
    }
}
