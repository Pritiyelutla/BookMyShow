package com.acciojob.BookMyShow.Repository;

import com.acciojob.BookMyShow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    public User findUserByMobNo(String mobNo);
}
