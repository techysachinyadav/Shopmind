package com.sachin.ecommerce.exception;

import com.sachin.ecommerce.dto.userresponsedto.GenericResponseDto;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler (UserNotFoundException.class)
    public ResponseEntity<GenericResponseDto> handleUserNotFoundException(UserNotFoundException e){
        GenericResponseDto genericResponseDto = new GenericResponseDto();
        genericResponseDto.setMessage("An error occurred. please try again.");
        genericResponseDto.setSuccess(false);
        genericResponseDto.setDetail(e.getMessage());

        return new ResponseEntity<>(genericResponseDto, HttpStatusCode.valueOf(400));
    }
}
