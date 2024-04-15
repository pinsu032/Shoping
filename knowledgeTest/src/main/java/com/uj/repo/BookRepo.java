package com.uj.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uj.entity.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {

}
