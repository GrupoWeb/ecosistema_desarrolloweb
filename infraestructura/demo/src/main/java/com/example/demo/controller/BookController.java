package com.example.demo.controller;

import com.example.demo.model.Demobook;
import com.example.demo.repository.DemobookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/books")
public class BookController {

    // @Autowired
    // BookService bookService;

    @Autowired
    DemobookRepository repositorio;

    // @GetMapping("")
    // public ResponseEntity<List<Book>> getAllBooks(){
    //     return ResponseEntity.ok(bookService.getBooks());
    // }

    @GetMapping("demo")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<List<Demobook>> getAllDemoBooks(){
        return ResponseEntity.ok((List)repositorio.findAll());
        
    }

    // @GetMapping("/isbn/{isbn}")
    // public ResponseEntity<Book> getBookByIsbn(@PathVariable String isbn){
    //     Optional<Book> optBook = bookService.getBookByIsbn(isbn);
    //     if(optBook.isPresent())
    //         return ResponseEntity.ok(optBook.get());
    //     return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Book());
    // }

    // @GetMapping("/danger")
    // public ResponseEntity<List<Book>> unstableBooksEndpoint(){
    //     return ResponseEntity.ok(bookService.longExecutionMethod());
    // }
}
