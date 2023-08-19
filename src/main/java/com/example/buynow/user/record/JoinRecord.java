package com.example.buynow.user.record;

import com.example.buynow.user.entity.User;
import com.example.buynow.user.repository.UserRepository;
import lombok.Builder;
import org.springframework.security.crypto.password.PasswordEncoder;

public record JoinRecord(String userid, String email, String username, String password, String address) {
    @Builder
    public JoinRecord{

    }

    public User toEntity(PasswordEncoder passwordEncoder, UserRepository userRepository){
        if(userRepository.existsByEmail(email)){
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }
        if(userRepository.existsByUserid(userid)){
            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
        }
        return User.builder()
                .username(username)
                .email(email)
                .userid(userid)
                .password(passwordEncoder.encode(password))
                .address(address)
                .build();
    }
}
