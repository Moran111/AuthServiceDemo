package com.example.demo.models.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "Permission")
@Data
public class PermissioinDomain implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "permissionName")
    private String permissionName;

    @Column(name = "permissionDescription")
    private String permissionDescription;

    @Column(name = "createDate")
    private String createDate;

    @Column(name = "modificationDate")
    private String modificationDate;

    @Column(name = "lastModificationUser")
    private String lastModificationUser;

    @OneToMany(mappedBy="permissionId")
    List<RolePermission> rolePermissionList;

    public PermissioinDomain() {
        this.createDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        this.modificationDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        this.lastModificationUser = "admin";
    }
}
