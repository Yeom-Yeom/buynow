package com.example.buynow.user.record;

import com.example.buynow.user.entity.User;

public record LoginResponseRecord(Long id, String username, String email, String userid, String password, String jwtToken) {
    public LoginResponseRecord(User entity, String jwtToken){
        this(entity.getId(), entity.getUsername(), entity.getEmail(), entity.getPassword(), entity.getUserid(), jwtToken);
    }
}
