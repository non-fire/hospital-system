package com.example.backend.controller.user.account;
import com.example.backend.service.user.account.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @PostMapping("/user/account/register/")
    public Map<String, String> register(@RequestParam Map<String, String> map) {
        String number = map.get("number");
        String name = map.get("name");
        String password = map.get("password");
        String confirmedPassword = map.get("confirmedPassword");
        String sex = map.get("sex");
        String age = map.get("age");
        String address = map.get("address");
        String phone = map.get("phone");
        System.out.println(password);
        System.out.println(sex);
        System.out.println(age);
        System.out.println(address);
        System.out.println(phone);
        return registerService.register(number, name,  password, confirmedPassword, Integer.parseInt(sex), Integer.parseInt(age), address, phone);
    }
}
