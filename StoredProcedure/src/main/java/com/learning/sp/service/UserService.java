package com.learning.sp.service;


import com.learning.sp.model.request.RegisterReqDTO;

public interface UserService {
    RegisterReqDTO createUser(RegisterReqDTO registerReqDTO);


}
