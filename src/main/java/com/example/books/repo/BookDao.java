package com.example.books.repo;

import com.example.books.model.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class BookDao implements Dao {

    private JdbcTemplate jdbcTemplate;

    public BookDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    public ArrayList<String> findAll() {
        ArrayList<String> resTitle = new ArrayList<>();
        List<Book> allTitle = (jdbcTemplate.query("select * from book ORDER by title DESC", ROW_MAPPER_TITLE));
        for(int i=0;i<allTitle.size();i++){
            resTitle.add(allTitle.get(i).getTitle());
        }
        return resTitle;
    }

    public Map<String, ArrayList<String>> findGroupAll() {
        List<String> author = findAll();
        Map<String, ArrayList<String>> groupAuthor = new HashMap<String, ArrayList<String>>();
        for(int i = 0; i < author.size(); i++){
            String authorName = author.get(i);
            List<Book> titleList =  jdbcTemplate.query("select title from book where author = '"+ authorName+"'" , ROW_MAPPER_TITLE);
            ArrayList<String> title = new ArrayList<>();
            for(int j=0; j < titleList.size();j++){
                title.add(titleList.get(j).getTitle());
            }
            groupAuthor.put(authorName, title);
        }
        return groupAuthor;
    }


    public int save(Book book) {
        return jdbcTemplate.update("INSERT INTO book (id, title, author, description)  " +
                "VALUES (?,?,?,?);",book.getId(), book.getTitle(),book.getAuthor(),book.getDescription());
    }
}