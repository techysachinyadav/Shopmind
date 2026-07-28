package com.sachin.ecommerce.dto.userresponsedto;

import lombok.Data;

@Data
public class GenericResponseDto {
    private String message;
    private boolean success;
    private Object detail;
}
