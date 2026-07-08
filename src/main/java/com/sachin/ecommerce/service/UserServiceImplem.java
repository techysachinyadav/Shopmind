package com.sachin.ecommerce.service;

import com.sachin.ecommerce.dto.userrequestdto.UserRequestDto;
import com.sachin.ecommerce.dto.userresponsedto.UserResponseDto;
import com.sachin.ecommerce.entity.User;
import com.sachin.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplem implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponseDto registerUser( UserRequestDto userRequestDto) {
    User user = mapRequestDtoToUser( new User(), userRequestDto);
    userRepository.save(user);

    //UserResponseDto userResponseDto = new UserResponseDto();
    return mapUserToResponseDto(user);
    }

    private User mapRequestDtoToUser (User user, UserRequestDto userRequestDto){
        user.setFirstName(userRequestDto.getFirstName());
        user.setLastName(userRequestDto.getLastName());
        user.setGender(userRequestDto.getGender());
        user.setPhoneNumber(userRequestDto.getPhoneNumber());
        user.setEmail(userRequestDto.getEmail());
        user.setAddress(userRequestDto.getAddress());
        user.setPass(userRequestDto.getPass());

        return user;
    }
    private UserResponseDto mapUserToResponseDto (User user){
         UserResponseDto userResponseDto = new UserResponseDto();
         userResponseDto.setId(user.getId());
         userResponseDto.setFirstName(user.getFirstName());
         userResponseDto.setLastName(user.getLastName());
         userResponseDto.setGender(user.getGender());
         userResponseDto.setPhoneNumber(user.getPhoneNumber());
         userResponseDto.setEmail(user.getEmail());
         userResponseDto.setAddress(user.getAddress());

         return userResponseDto;
    }
}
