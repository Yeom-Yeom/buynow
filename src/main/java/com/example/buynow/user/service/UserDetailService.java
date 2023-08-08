package com.example.buynow.user.service;

import com.example.buynow.user.entity.User;
import com.example.buynow.user.entity.UserDetail;
import com.example.buynow.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username){
        System.out.println("username = "+ username);
        return new UserDetail(getUsername(username).orElseThrow(()-> new EntityNotFoundException("해당 유저가 없습니다.")));
    }

    public Optional<User> getUsername(String username){ return userRepository.findByUsername(username); }
}
