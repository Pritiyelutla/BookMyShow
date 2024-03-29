package com.acciojob.BookMyShow.Repository;

import com.acciojob.BookMyShow.models.Show;
import com.acciojob.BookMyShow.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatListRepository extends JpaRepository<ShowSeat,Integer> {

    public List<ShowSeat> findAllByShow(Show show);

}
