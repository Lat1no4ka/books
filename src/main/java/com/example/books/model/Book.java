package com.example.books.model;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_pk")
    private Long Book_pk;
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String Title;
    @Column(name = "author")
    private String Author;
    @Column(name = "description")
    private String Description = null;

    public Book(int id, String title, String author, String description) {
        this.id = id;
        Title = title;
        Author = author;
        Description = description;
    }

    public Book(String title) {
        Title = title;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Long getBook_pk() {
        return Book_pk;
    }

    public void setBook_pk(Long book_pk) {
        Book_pk = book_pk;
    }
}
