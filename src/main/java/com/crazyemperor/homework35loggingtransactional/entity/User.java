package com.crazyemperor.homework35loggingtransactional.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "Users")
public class User {

    @Id
    @Column(name = "UserID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;

    @Basic(optional = false)
    @Column(name = "Nickname")
    private String nickname;

    @Basic(optional = false)
    @Column(name = "First name")
    private String firstName;

    @Basic(optional = false)
    @Column(name = "Last name")
    private String lastName;

    @Basic(optional = false)
    @Column(name = "Age")
    private Integer age;

    @Column(name = "Sex")
    private Sex sex;

    @Column(name = "Address")
    private String address;

    @Column(name = "City")
    private String city;

    @Column(name = "Post index")
    private String postIndex;

    @Column(name = "Country")
    private String Country;

    @Column(name = "Point")
    private Integer point;

    @Basic(optional = false)
    @Column(name = "Is blocked")
    private boolean isBlocked;
}
