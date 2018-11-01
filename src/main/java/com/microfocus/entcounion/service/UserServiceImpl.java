package com.microfocus.entcounion.service;

import com.microfocus.entcounion.dao.UserDetailDao;
import com.microfocus.entcounion.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource(name = "userDetailDao")
    private UserDetailDao userDetailDao;

    @Override
    public void createUser(UserDetails user) {
        userDetailDao.saveAndFlush(user);
    }

    @Override
    public void updateUser(UserDetails user) {

    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public boolean userExists(String username) {
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDetailDao.findUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User:"+username+" not found!"));
    }
}
