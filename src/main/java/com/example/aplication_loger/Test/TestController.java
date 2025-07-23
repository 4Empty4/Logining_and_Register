package com.example.aplication_loger.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class TestController {



    private TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserRequestFormDto> login(@RequestBody UserLoginFormDto loginDto) {
        UserRequestFormDto userDto = testService.authenticate(
                loginDto.getLogin(),
                loginDto.getPassword()
        );
        return ResponseEntity.ok(userDto);
    }
}
