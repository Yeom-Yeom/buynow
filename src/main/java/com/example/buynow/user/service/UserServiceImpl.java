package com.example.buynow.user.service;

import com.example.buynow.user.entity.User;
import com.example.buynow.user.record.JoinRecord;
import com.example.buynow.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Long join(JoinRecord joinRecord){
        return userRepository.save(joinRecord.toEntity(passwordEncoder,userRepository)).getId();
    }

    @Transactional(readOnly = true)
    public User login(String userid, String password){
        User entity = userRepository.findByUserid(userid).orElseThrow(()-> new EntityNotFoundException("유저를 찾을 수 없습니다"));
        if(passwordEncoder.matches(password, entity.getPassword())){
            return entity;
        }
        else return null;
    }
}
