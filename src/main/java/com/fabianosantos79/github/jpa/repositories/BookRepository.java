package com.fabianosantos79.github.jpa.repositories;

import com.fabianosantos79.github.jpa.models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface BookRepository extends JpaRepository<BookModel, UUID> {
    public BookModel findBookModelByTitle(String title);

    @Query(value = "SELECT * FROM tb_book WHERE publisher_id = :id", nativeQuery = true)
    public List<BookModel> findBooksByPublisherId(@Param("id") UUID id);
}
