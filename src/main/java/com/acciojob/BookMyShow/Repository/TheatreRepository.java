package com.acciojob.BookMyShow.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.acciojob.BookMyShow.models.Theatre;
@Repository

public interface TheatreRepository extends JpaRepository<Theatre, Integer> {
}
