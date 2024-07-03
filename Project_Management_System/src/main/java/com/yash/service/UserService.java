package com.yash.service;

import com.yash.model.User;

public interface UserService {

    User findUserProfileByJwt(String jwt)throws Exception;

    User findUserByEmail(String email)throws Exception;

    User findUserById(Long uerId)throws Exception;

     User updateUserProjectSize(User user , int number);







}
