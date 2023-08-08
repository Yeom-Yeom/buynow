package com.example.buynow.user.service;

import com.example.buynow.user.entity.User;
import com.example.buynow.user.record.JoinRecord;

public interface UserService {
    Long join(JoinRecord joinRecord);
    User login(String userid, String password);
}
