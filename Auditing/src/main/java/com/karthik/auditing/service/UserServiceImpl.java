package com.karthik.auditing.service;


import com.karthik.auditing.entity.RegisterUser;
import com.karthik.auditing.repository.UserInfoRepository;
import com.karthik.auditing.request.RegisterReqDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements UserService{
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Override
    public RegisterReqDTO createUser(RegisterReqDTO registerReqDTO) {
        RegisterUser user = modelMapper.map(registerReqDTO, RegisterUser.class);
        RegisterUser savedUser = userInfoRepository.save(user);
        return modelMapper.map(savedUser, RegisterReqDTO.class);
    }
}
