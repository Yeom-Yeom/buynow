package com.example.buynow.user.controller;

import com.example.buynow.jwt.JwtUtils;
import com.example.buynow.response.SingleResponseData;
import com.example.buynow.user.entity.User;
import com.example.buynow.user.record.JoinRecord;
import com.example.buynow.user.record.LoginRecord;
import com.example.buynow.user.record.LoginResponseRecord;
import com.example.buynow.user.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.example.buynow.jwt.JwtProperties.*;

@RestController
@RequiredArgsConstructor
//@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/members")
public class UserController {
    private final UserService signUpService;

    @PostMapping("/join")
    public SingleResponseData<Long> join(@RequestBody JoinRecord joinRecord){
        return SingleResponseData.of(signUpService.join(joinRecord));
    }

    @PostMapping("/login")
    public SingleResponseData<LoginResponseRecord> login(HttpServletResponse response, @RequestBody LoginRecord loginRecord){
        User entity = signUpService.login(loginRecord.userid(), loginRecord.password());
        if(entity == null){
            throw new IllegalArgumentException("올바르지 않은 비밀번호입니다.");
        }
        String jwtToken = TOKEN_PREFIX.concat(JwtUtils.createJwtToken(entity));
        response.addHeader(HEADER_STRING, jwtToken);

        LoginResponseRecord loginResponseRecord = new LoginResponseRecord(entity, jwtToken);
        return SingleResponseData.of(loginResponseRecord);
    }
}
