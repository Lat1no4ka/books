package com.example.books.controllers;


import com.example.books.model.Book;
import com.example.books.repo.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/api",produces = "application/json")
@ResponseBody
public class BookController {

    @Autowired
    public BookDao dao;

    @RequestMapping(value = "/getBooks", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ArrayList<String> getBooks() {
        return dao.findAll();
    }

    @RequestMapping(value = "/addBook",
            method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
    @ResponseBody
    public String addBook(@RequestBody Book book) {
        dao.save(book);
        return "string";
    }
    @RequestMapping(value = "/getBooks", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    @GetMapping("/getGroupBooks")
    public Map<String, ArrayList<String>> getGroupBooks()
    {
        return dao.findGroupAll();
    }


}

