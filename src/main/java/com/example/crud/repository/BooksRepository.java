package com.example.crud.repository;

import com.example.crud.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BooksRepository extends JpaRepository<Books, Long> {

    public List<Books> findByMainGenreOrSubGenre (String main_genre,String sub_genre);

    public List<Books> findByAuthor(String author);
}
