package com.karthik.auditing.service;


import com.karthik.auditing.request.RegisterReqDTO;

public interface UserService {
    RegisterReqDTO createUser(RegisterReqDTO registerReqDTO);

  //  UserResponse getAllUsers(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);


 //   UserDTO updateUser(Long userId, UserDTO userDTO);

 //   String deleteUser(Long userId);
}
