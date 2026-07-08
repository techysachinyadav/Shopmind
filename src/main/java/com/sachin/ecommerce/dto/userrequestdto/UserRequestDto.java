package com.sachin.ecommerce.dto.userrequestdto;

import com.sachin.ecommerce.enums.Gender;
import lombok.Data;

@Data
public class UserRequestDto {

    private String firstName;
    private String lastName;
    private Gender gender;
    private String email;
    private String address;
    private String pass;
    private String phoneNumber;
}
