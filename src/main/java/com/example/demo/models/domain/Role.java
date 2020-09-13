package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.io.Serializable;

@Entity
@Table(name = "Role")
@Data
public class Role implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "roleName")
    private String roleName;

    @Column(name = "description")
    private String description;

    @Column(name = "createDate")
    private String createDate;

    @Column(name = "modificationDate")
    private String modificationDate;

    @OneToMany(mappedBy="roleId")
    List<UserRole> userRoles;

    @OneToMany(mappedBy="permissionId")
    List<RolePermission> rolePermissions;
}
