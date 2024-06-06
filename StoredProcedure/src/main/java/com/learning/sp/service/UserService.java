package com.learning.sp.service;


import com.learning.sp.model.request.RegisterReqDTO;

import java.util.List;

public interface UserService {
    RegisterReqDTO createUser(RegisterReqDTO registerReqDTO);

    List<RegisterReqDTO> getAllUsers();
}
