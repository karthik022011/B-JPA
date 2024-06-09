package com.learning.entity.relations.onetomany.bi.repository;

import com.learning.entity.relations.onetomany.bi.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
