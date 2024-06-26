package com.learning.sp.service;



import com.learning.sp.entity.RegisterUser;
import com.learning.sp.model.request.RegisterReqDTO;
import com.learning.sp.repository.UserInfoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

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
        return modelMapper.map(savedUser,RegisterReqDTO.class);
    }

    @Override
    public List<RegisterReqDTO> getAllUsers() {
        List<RegisterUser> users = userInfoRepository.getAllUsers();
        Type listType = new TypeToken<List<RegisterReqDTO>>(){}.getType();
        return modelMapper.map(users, listType);
    }
}
