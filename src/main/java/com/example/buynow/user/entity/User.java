package com.example.buynow.user.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@Table(name= "user")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String userid;

    @Column(nullable = false)
    private String password;

    @Builder
    public User(String email, String username, String userid, String password){
        this.email = email;
        this.username = username;
        this.userid = userid;
        this.password = password;
    }
}
