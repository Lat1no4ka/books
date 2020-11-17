package com.example.books.controllers;


import com.example.books.model.Book;
import com.example.books.repo.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@RestController
@RequestMapping(value = "/api",produces = "application/json")
@ResponseBody
public class BookController {


    @Autowired
    public BookDao dao;

    @RequestMapping(value = "/getBooks", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<String> getBooks() {
        List<String> stringList =  dao.findAll();
        List<String> sortedList = stringList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        return sortedList;
    }

    @RequestMapping(value = "/addBook",
            method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
    @ResponseBody
    public Book addBook(@RequestBody Book book) {
        dao.save(book);
        return book;
    }
    @RequestMapping(value = "/getGroupBooks", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Map<String, ArrayList<String>> getGroupBooks()
    {
        return dao.findGroupAll();
    }


}

