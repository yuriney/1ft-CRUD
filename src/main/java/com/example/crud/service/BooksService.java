package com.example.crud.service;

import com.example.crud.entity.Books;
import com.example.crud.repository.BooksRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {
    @Autowired
    BooksRepository booksRepository;


    public List<Books> getAllBooks(){
        return booksRepository.findAll();
    }

    public Books getBookById(Long id){
        return booksRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Book Not Found With Id: " + id));
    }

    public List<Books> findByMainGenreOrSubGenre(String genre){
        return booksRepository.findByMainGenreOrSubGenre(genre, genre);
    }

    public Books postBooks(Books book){
        return booksRepository.save(book);
    }

    public List<Books> findByAuthor(String author){
        return booksRepository.findByAuthor(author);
    }
}
