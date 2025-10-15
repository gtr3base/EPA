package com.gtr3base.EventPlaner.dto;

import com.gtr3base.EventPlaner.dto.enums.UserRole;
import lombok.Getter;

@Getter
public class UserDTO {
    private String username;
    private String email;
    private String password;
    private UserRole role;
}
