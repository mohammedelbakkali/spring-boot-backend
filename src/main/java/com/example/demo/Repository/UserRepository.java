package com.example.demo.Repository;

import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findAllByEmailIgnoreCase(String email);
    @Query("from User where firstname='%:firstName%'")
    List<User> serchByFirstName(@Param("firstName") String firstName);


    @Query(value = "select * from _user where firstname=:firstName",nativeQuery = true)
    List<User> serchByFirstNameNative(@Param("firstName") String firstName);
}
