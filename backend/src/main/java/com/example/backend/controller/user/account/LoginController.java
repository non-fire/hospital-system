package com.example.backend.controller.user.account;

import com.example.backend.service.user.account.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/user/account/token/")
    public Map<String, String> getToken(@RequestParam Map<String, String> map) {
        String number = map.get("number");
        String password = map.get("password");

        System.out.println(number + ' ' + password);
        return loginService.getToken(number, password);
    }
}
