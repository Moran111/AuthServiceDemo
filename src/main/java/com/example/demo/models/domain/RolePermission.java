package com.example.demo.models.domain;


import com.example.demo.models.domain.PermissioinDomain;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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

    @ManyToOne
    @JoinColumn(name = "roleId", nullable=false)
    private Role roleId;

    @Column(name = "activeFlag")
    private String activeFlag;

    @Column(name = "createDate")
    private String createDate;

    @Column(name = "modificationDate")
    private String modificationDate;

    @Column(name = "lastModificationUser")
    private String lastModificationUser;

    public RolePermission () {
        this.activeFlag = "Y";
        this.createDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        this.modificationDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        this.lastModificationUser = "admin";
    }
}
