package com.mymoney.finance_control.services;

import com.mymoney.finance_control.models.UserModel;
import com.mymoney.finance_control.repositories.MoneyRepository;
import com.mymoney.finance_control.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MoneyRepository moneyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Optional<UserModel> findUserById(UUID id){
        return userRepository.findById(id);
    }

    public void registerUser(UserModel userModel){

        if(userModel.getUsername().isEmpty() || userModel.getPassword().isEmpty()){
            throw new RuntimeException("Empty fields!");
        }

        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        userModel.setUsername(userModel.getUsername().toLowerCase().trim());
        userRepository.save(userModel);
    }

    public boolean validateUser(UserModel userModel){
        Optional<UserModel> findedUser = userRepository
                .findUserByUsername(userModel
                        .getUsername()
                        .toLowerCase()
                        .trim()
                );

        if(findedUser.isPresent()){
            return passwordEncoder.matches(userModel.getPassword(), findedUser.get().getPassword());
        }else{
            return false;
        }
    }
}
