package com.uj.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uj.entity.Author;

public interface AuthorRepo extends JpaRepository<Author, Integer> {

}
