package com.api.book1.bootrestbook.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.book1.bootrestbook.entity.Books;

@Repository
public interface BookRepo extends CrudRepository<Books, Integer> {

}
