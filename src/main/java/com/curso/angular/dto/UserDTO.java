package com.curso.angular.dto;

import java.time.LocalDateTime;

import com.curso.angular.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	private Long id;
    private String name;
    private String email;
    private String password;
    private LocalDateTime createdAt;
    
    public UserDTO(User usuario) {
        this.id = usuario.getId();
        this.name = usuario.getName();
        this.email = usuario.getEmail();
        this.password = usuario.getPassword();
        this.createdAt = usuario.getCreatedAt();
    }
}
