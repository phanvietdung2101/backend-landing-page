package com.sopen.landingpageviettel.demo.service;

import com.sopen.landingpageviettel.demo.models.user.User;

public interface UserService {
    ServiceResult updateUser(User user, String username);
    ServiceResult changePassword(User user, String checkPassword, String newPassword);
    ServiceResult getByUserName(String username);
}
