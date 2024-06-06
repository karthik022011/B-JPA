package com.learning.sp.controller;


import com.learning.sp.model.request.RegisterReqDTO;
import com.learning.sp.service.UserService;
import com.learning.sp.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/admin/users")
    public ResponseEntity<ApiResponse<List<RegisterReqDTO>>> getAllUsers(){
        List<RegisterReqDTO> users = userService.getAllUsers();
        ApiResponse<List<RegisterReqDTO>> response = new ApiResponse<>();
        response.setStatus(HttpStatus.OK.value());
        response.setSuccess(true);
        response.setMessage("Succeeded");
        response.setData(users);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

}
