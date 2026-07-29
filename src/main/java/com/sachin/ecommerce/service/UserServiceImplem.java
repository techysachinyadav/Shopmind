package com.sachin.ecommerce.service;

import com.sachin.ecommerce.config.SecurityConfig;
import com.sachin.ecommerce.dto.userrequestdto.UserRequestDto;
import com.sachin.ecommerce.dto.userresponsedto.GenericResponseDto;
import com.sachin.ecommerce.dto.userresponsedto.UserResponseDto;
import com.sachin.ecommerce.entity.User;
import com.sachin.ecommerce.exception.UserNotFoundException;
import com.sachin.ecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service

public class UserServiceImplem implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDto registerUser( UserRequestDto userRequestDto) {
    User user = mapRequestDtoToUser( new User(), userRequestDto);
    userRepository.save(user);

    //UserResponseDto userResponseDto = new UserResponseDto();
    return mapUserToResponseDto(user);
    }

    @Override
    public UserResponseDto getUser(Long id) {
        User user = userRepository.findById(id).orElseThrow( ()-> new UserNotFoundException("User : "+id+" User not found"));
        return mapUserToResponseDto(user);
    }

    @Override
    public List<UserResponseDto> getAllUser() {
        List<User> userList = userRepository.findAll();
        List<UserResponseDto> userResponseDtoList = new LinkedList<>();

        for (User user : userList){
            userResponseDtoList.add(mapUserToResponseDto(user));
        }
        return userResponseDtoList;
    }

    @Override
    public UserResponseDto updateUser(Long id, UserRequestDto userRequestDto) {
        User user = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User :"+id+"not found."));
            mapRequestDtoToUser(user, userRequestDto);
            userRepository.save(user);

        return mapUserToResponseDto(user);
    }

    @Override
    public GenericResponseDto deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User:"+ id +"not found."));
        userRepository.delete(user);
        GenericResponseDto genericResponseDto = new GenericResponseDto();
        genericResponseDto.setDetail(user);
        genericResponseDto.setSuccess(true);
        genericResponseDto.setMessage("User deleted successfully");


        return genericResponseDto;
    }

    @Override
    public UserDetails findUserbyUsername(String username) {
        return userRepository.findByEmail(username).orElseThrow(() -> new UserNotFoundException("User not exist"));

    }


    private User mapRequestDtoToUser (User user, UserRequestDto userRequestDto){
        user.setFirstName(userRequestDto.getFirstName());
        user.setLastName(userRequestDto.getLastName());
        user.setGender(userRequestDto.getGender());
        user.setPhoneNumber(userRequestDto.getPhoneNumber());
        user.setRole(userRequestDto.getRole());
        user.setEmail(userRequestDto.getEmail());
        user.setAddress(userRequestDto.getAddress());
        user.setPass(passwordEncoder.encode(userRequestDto.getPass()));

        return user;
    }
    private UserResponseDto mapUserToResponseDto (User user){
         UserResponseDto userResponseDto = new UserResponseDto();
         userResponseDto.setId(user.getId());
         userResponseDto.setFirstName(user.getFirstName());
         userResponseDto.setLastName(user.getLastName());
         userResponseDto.setGender(user.getGender());
         userResponseDto.setPhoneNumber(user.getPhoneNumber());
         userResponseDto.setRole(user.getRole());
         userResponseDto.setEmail(user.getEmail());
         userResponseDto.setAddress(user.getAddress());

         return userResponseDto;
    }
}
