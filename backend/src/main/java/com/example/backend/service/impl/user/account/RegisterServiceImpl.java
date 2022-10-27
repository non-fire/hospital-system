package com.example.backend.service.impl.user.account;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.backend.mapper.UserMapper;
import com.example.backend.pojo.User;
import com.example.backend.service.user.account.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Map<String, String> register(String number, String name,  String password, String confirmedPassword, Integer sex, Integer age, String address, String phone) {
        Map<String, String> map = new HashMap<>();
        if (name == null) {
            map.put("error_message", "姓名不能为空");
            return map;
        }

        if (number == null) {
            map.put("error_message", "身份证号不能为空");
            return map;
        }

        if (password == null || confirmedPassword == null) {
            map.put("error_message", "密码不能为空");
            return map;
        }

        if (password.length() == 0 || confirmedPassword.length() == 0) {
            map.put("error_message", "密码不能为空");
            return map;
        }

        if (name.length() > 100) {
            map.put("error_message", "姓名长度不能大于100");
            return map;
        }

        if (number.length() > 100) {
            map.put("error_message", "身份证号码长度不能大于100");
            return map;
        }

        if (password.length() > 100 || confirmedPassword.length() > 100) {
            map.put("error_message", "密码不能大于100");
            return map;
        }

        if (!password.equals(confirmedPassword)) {
            map.put("error_message", "两次输入的密码不一致");
            return map;
        }

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("number", number);
        System.out.println("1");
        List<User> users = userMapper.selectList(queryWrapper);
        if(!users.isEmpty()) {
            map.put("error_message", "用户名已存在");
            return map;
        }

        // 添加一个新用户
        String encodedPassword = passwordEncoder.encode(password);

        User user = new User(null, number, name, encodedPassword, sex, age, address, phone);
        userMapper.insert(user);
        System.out.println("2");
        map.put("error_message", "success");
        return map;
    }
}
