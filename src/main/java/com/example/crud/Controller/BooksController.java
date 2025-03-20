package com.example.crud.Controller;

import com.example.crud.entity.Books;
import com.example.crud.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {
    @Autowired
    BooksService booksService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Books> getAllBooks(){
        return booksService.getAllBooks();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Books getBookByID(@PathVariable long id){
        return booksService.getBookById(id);
    }

    @GetMapping("/genre/{genre}")
    @ResponseStatus(HttpStatus.OK)
    public List<Books> getBooksByGenre(@PathVariable String genre){
        return booksService.findByMainGenreOrSubGenre(genre);
    };

    @GetMapping("/author/{author}")
    @ResponseStatus(HttpStatus.OK)
    public List<Books> getBooksByAuthor(@PathVariable String author){
        return booksService.findByAuthor(author);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Books SalvarLivro(@RequestBody Books book) { return booksService.postBooks(book);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBook(@PathVariable Long id){
        booksService.deleteBookById(id);
    }
}
