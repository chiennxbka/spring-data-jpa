package com.alibaba.academy.repository;

import com.alibaba.academy.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    List<Users> findByFirstNameLike(String firstName);

    List<Users> findByEmail(String email);

    List<Users> findByLastNameLike(String lastName);
}
