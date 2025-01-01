package com.fabianosantos79.github.jpa.controllers;

import com.fabianosantos79.github.jpa.dtos.BookDto;
import com.fabianosantos79.github.jpa.models.BookModel;
import com.fabianosantos79.github.jpa.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bookstore/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookModel> saveBook(@RequestBody BookDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.saveBook(dto));
    }

    @GetMapping
    public ResponseEntity<List<BookModel>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.bookService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        this.bookService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Livro deletado com sucesso!");
    }
}
