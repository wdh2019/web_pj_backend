package com.webproject.backend.controller;

import com.webproject.backend.Response.Message;
import com.webproject.backend.entity.User;
import com.webproject.backend.security.JwtTokenUtil;
import com.webproject.backend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class AuthController {

    private final AuthService service;

    private JwtTokenUtil tokenUtil;

    @Autowired
    public AuthController(AuthService service, JwtTokenUtil tokenUtil){
        this.service = service;
        this.tokenUtil = tokenUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody HashMap<String, Object> params){
        String username = (String)params.get("username");
        String password = (String)params.get("password");
        if(service.register(username,password))
            return ResponseEntity.ok(Message.newMessage("success"));
        else
            return ResponseEntity.ok(Message.newMessage("failure"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody HashMap<String,Object> params){
        String username = (String)params.get("username");
        String password = (String)params.get("password");
        User user = service.login(username,password);
        if(user != null){
            String token = tokenUtil.generateToken(user);
            HashMap<String,Object> map = new HashMap<>();
            map.put("message","success");
            map.put("token", token);
            map.put("user",user);
            return ResponseEntity.ok(map);
        }else{
            return ResponseEntity.ok(Message.newMessage("failure"));
        }
    }
}
