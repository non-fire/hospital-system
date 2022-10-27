package com.example.backend.service.user.account;

import java.util.Map;

public interface RegisterService {
    public Map<String, String> register(String idNumber,String name, String password, String confirmedPassword, Integer sex, Integer age, String address, String phone);
}
