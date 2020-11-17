package com.example.books.repo;

import com.example.books.model.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface Dao  {


    RowMapper<Book> ROW_MAPPER_TITLE = (ResultSet resultSet, int rowNum) -> {
        return new Book( resultSet.getString("title"));
    };


    ArrayList<String> findAll();
    Map<String, ArrayList<String>> findGroupAll();
    int save(Book book);
}


