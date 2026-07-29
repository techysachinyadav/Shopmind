package com.sachin.ecommerce.repository;

import com.sachin.ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

   // boolean existByEmail (String email);
    //boolean existByPhoneNumber (String phoneNumber);
    //Optional<User> findByEmail (String email);
    Optional<User> findByEmail (String email);
}
