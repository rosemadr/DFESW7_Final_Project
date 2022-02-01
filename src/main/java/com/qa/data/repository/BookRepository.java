package com.qa.data.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.*;

import com.qa.data.entity.*;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
