package com.sopen.landingpageviettel.demo.service.impl;

import com.sopen.landingpageviettel.demo.models.user.User;
import com.sopen.landingpageviettel.demo.repository.UserRepository;
import com.sopen.landingpageviettel.demo.service.ServiceResult;
import com.sopen.landingpageviettel.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public ServiceResult updateUser(User user, String username) {
        ServiceResult serviceResult = new ServiceResult();

        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (!optionalUser.isPresent()) {
            serviceResult.setMessage("No found user");
            return serviceResult;
        }
        User currentUser = optionalUser.get();
        userRepository.save(currentUser);
        serviceResult.setMessage("Update success");
        return serviceResult;
    }

    @Override
    public ServiceResult changePassword(User user, String oldPassword, String newPassword) {
        ServiceResult serviceResult = new ServiceResult();

        if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
            serviceResult.setMessage("Check password fail");
        } else {
            user.setPassword(passwordEncoder.encode(newPassword));
            userRepository.save(user);
            serviceResult.setData(user);
        }
        return serviceResult;
    }

    @Override
    public ServiceResult getByUserName(String username) {
        ServiceResult serviceResult = new ServiceResult();
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (!optionalUser.isPresent()) {
            serviceResult.setMessage("No found user");
            return serviceResult;
        } else serviceResult.setData(optionalUser);
        return serviceResult;
    }
}
