package com.example.crud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "books")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @Column(name = "author")
    private String author;
    @Column(name = "main_genre")
    private String mainGenre;
    @Column(name = "sub_genre")
    private String subGenre;

    private String type;
    private BigDecimal price;          // NUMERIC(10,2) -> BigDecimal
    private BigDecimal rating;         // NUMERIC(2,1) -> BigDecimal
    private Integer no_of_people_rated; // INTEGER -> Integer

    private String url;
}
