package com.example.demo.models;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "RolePermission")
@Data
public class RolePermission implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name="permissionId", nullable=false)
    private PermissioinDomain permissionId;

    @Column(name = "roleId")
    private int roleId;

    @Column(name = "activeFlag")
    private String activeFlag;

    @Column(name = "createDate")
    private String createDate;

    @Column(name = "modificationDate")
    private String modificationDate;

    @Column(name = "lastModificationUser")
    private String lastModificationUser;
}
