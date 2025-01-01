package com.fabianosantos79.github.jpa.services;

import com.fabianosantos79.github.jpa.dtos.BookDto;
import com.fabianosantos79.github.jpa.models.BookModel;
import com.fabianosantos79.github.jpa.models.ReviewModel;
import com.fabianosantos79.github.jpa.repositories.AuthorRepository;
import com.fabianosantos79.github.jpa.repositories.BookRepository;
import com.fabianosantos79.github.jpa.repositories.PublisherRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BookService(BookRepository bookRepository,
                       AuthorRepository authorRepository,
                       PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Transactional
    public BookModel saveBook(BookDto dto){
        BookModel book = new BookModel();
        book.setTitle(dto.title());
        book.setPublisher(this.publisherRepository.findById(dto.publisherId()).get());
        book.setAuthors(this.authorRepository.findAllById(dto.authorsIds()).stream().collect(Collectors.toSet()));

        ReviewModel review = new ReviewModel();
        review.setComment(dto.reviewComment());
        review.setBook(book);

        book.setReview(review);

        return bookRepository.save(book);
    }


    public List<BookModel> getAll(){
        return this.bookRepository.findAll();
    }


    @Transactional
    public void delete(UUID id){
        this.bookRepository.deleteById(id);
    }
}
