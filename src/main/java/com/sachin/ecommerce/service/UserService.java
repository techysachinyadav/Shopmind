package com.sachin.ecommerce.service;

import com.sachin.ecommerce.dto.userrequestdto.UserRequestDto;
import com.sachin.ecommerce.dto.userresponsedto.GenericResponseDto;
import com.sachin.ecommerce.dto.userresponsedto.UserResponseDto;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {
    UserResponseDto registerUser (UserRequestDto userRequestDto);
    UserResponseDto getUser(Long id);
    List<UserResponseDto> getAllUser();
    UserResponseDto updateUser(Long id, UserRequestDto userRequestDto);
    GenericResponseDto deleteUser(Long id);
    UserDetails findUserbyUsername(String username);
}
