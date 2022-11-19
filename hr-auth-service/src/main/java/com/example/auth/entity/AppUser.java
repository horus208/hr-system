package com.example.auth.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
    @Id
    private String email;
    @Column(nullable = false)
    private String pwd;
    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private Role role;





}
