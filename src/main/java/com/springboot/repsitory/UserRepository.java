package com.springboot.repsitory;

import com.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.LockModeType;
import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT u FROM User u WHERE userName = :userName")
    List<User> findAllByUserName(@Param("userName") String userName);

    User findByUserName(@Param("userName") String userName);
}
