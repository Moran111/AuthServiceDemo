package com.example.demo.models.domain;


import com.example.demo.models.domain.Role;
import lombok.Data;
import java.io.Serializable;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "User")
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "userName")
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "personId")
    private int personId;

    @Column(name = "createDate")
    private String createDate;

    @Column(name = "modificationDate")
    private String modificationDate;

    @OneToMany(mappedBy="userId")
    private List<UserRole> userRoles;

}
