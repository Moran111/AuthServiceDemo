package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "UserRole")
@Data
public class UserRole implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

//    @Column(name = "userId")
//    private int userId;

    @ManyToOne
    @JoinColumn(name = "roleId", nullable = false)
    private Role roleId;

    @Column(name = "activeFlag")
    private String activeFlag;

    @Column(name = "createDate")
    private String createDate;

    @Column(name = "modificationDate")
    private String modificationDate;

    @Column(name = "lastModificationUser")
    private String lastModificationUser;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User userId;
}
