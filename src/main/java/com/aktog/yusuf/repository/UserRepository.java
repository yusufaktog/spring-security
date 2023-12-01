package com.aktog.yusuf.repository;

import com.aktog.yusuf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findUserByUsername(String name);
    Optional<User> findUserByMail(String mail);

}
