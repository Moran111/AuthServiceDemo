package com.example.demo.models.domain;

import lombok.Data;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

    @Column (name = "lastModificationUser")
    private String lastModificationUser;

    @OneToMany(mappedBy="roleId")
    List<UserRole> userRole;

    @OneToMany(mappedBy="roleId")
    List<RolePermission> rolePermissions;

    public Role() {
        this.createDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        this.modificationDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        this.lastModificationUser = "admin";
    }
}
