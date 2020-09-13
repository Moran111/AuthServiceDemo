package com.example.demo.models.domain;

import com.example.demo.models.domain.Role;
import com.example.demo.models.domain.User;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Entity
@Table(name = "UserRole")
@Data
public class UserRole implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

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


    public UserRole () {
        this.activeFlag = "Y";
        this.createDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        this.modificationDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
    }

}
