package com.yash.service;

import com.yash.config.JwtProvider;
import com.yash.model.User;
import com.yash.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository  userRepository;
    


    @Override
    public User findUserProfileByJwt(String jwt) throws Exception {
        String email= JwtProvider.getEmailFromToken(jwt);

        return findUserByEmail(email);
    }

    @Override
    public User findUserByEmail(String email) throws Exception {
        User user = userRepository.findByEmail(email);
        if (user==null){
            throw new Exception("user not found");
        }
        return user;
    }

    @Override
    public User findUserById(Long uerId) throws Exception {
        Optional<User> optionalUser=userRepository.findById(uerId);
        if (optionalUser.isEmpty()){
            throw new Exception("user not found ");
        }
        return optionalUser.get();
    }

    @Override
    public User updateUserProjectSize(User user, int number) {
        user.setProjectSize(user.getProjectSize()+number);
        return userRepository.save(user);
    }
}
