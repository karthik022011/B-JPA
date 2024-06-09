package com.karthik.auditing.controller;


import com.karthik.auditing.request.RegisterReqDTO;
import com.karthik.auditing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping("/signup")
    public ResponseEntity<RegisterReqDTO> createUser(@RequestBody RegisterReqDTO registerReqDTO){
        RegisterReqDTO savedUser = userService.createUser(registerReqDTO);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

}
