package com.food_delivery.repository;

import com.food_delivery.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmailId(String email);

    boolean existsByMobileNo(String mobileNo);
    boolean existsByEmailId(String emailId);
}