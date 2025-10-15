package com.gtr3base.EventPlaner.model;

import com.gtr3base.EventPlaner.dto.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id @GeneratedValue
    private Long id;
    private String username;
    private String email;
    private String password;
    private UserRole role;

    @OneToMany(mappedBy = "assignedTo")
    private List<Task> tasks;

}
