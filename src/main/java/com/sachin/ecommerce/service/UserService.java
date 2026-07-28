package com.sachin.ecommerce.service;

import com.sachin.ecommerce.dto.userrequestdto.UserRequestDto;
import com.sachin.ecommerce.dto.userresponsedto.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto registerUser (UserRequestDto userRequestDto);
    UserResponseDto getUser(Long id);

}
