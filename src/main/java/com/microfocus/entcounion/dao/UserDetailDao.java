package com.microfocus.entcounion.dao;


import com.microfocus.entcounion.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Component
public interface UserDetailDao extends JpaRepository<User, Long> {

    <S extends User> Optional<User>  saveAndFlush(UserDetails userDetails);

    <S extends User> Optional<User> findUserByUsername(String username);

    <S extends User> Optional<User> findUserByUsernameOrEmail(String identity);
}
