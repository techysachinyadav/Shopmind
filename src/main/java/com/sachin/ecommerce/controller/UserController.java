package com.sachin.ecommerce.controller;

import com.sachin.ecommerce.dto.userrequestdto.UserRequestDto;
import com.sachin.ecommerce.dto.userresponsedto.GenericResponseDto;
import com.sachin.ecommerce.dto.userresponsedto.UserResponseDto;
import com.sachin.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
   public ResponseEntity<UserResponseDto> registerUser (@RequestBody UserRequestDto userRequestDto){
        return new ResponseEntity<>(userService.registerUser(userRequestDto), HttpStatusCode.valueOf(201));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserResponseDto> getUser (@PathVariable Long id){
    return new ResponseEntity<>(userService.getUser(id),HttpStatusCode.valueOf(200));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserResponseDto>> getAllUser (){
        return new ResponseEntity<>(userService.getAllUser(),HttpStatusCode.valueOf(200));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponseDto> updateUser (@PathVariable Long id, @RequestBody UserRequestDto userRequestDto){
        return new ResponseEntity<>(userService.updateUser(id, userRequestDto),HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GenericResponseDto> deleteUser (@PathVariable  Long id){
        return new ResponseEntity<>(userService.deleteUser(id),HttpStatusCode.valueOf(200));
    }
}
