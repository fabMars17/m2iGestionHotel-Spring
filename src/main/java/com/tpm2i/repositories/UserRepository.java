package com.tpm2i.repositories;

import com.tpm2i.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByUserName(String username);
}
