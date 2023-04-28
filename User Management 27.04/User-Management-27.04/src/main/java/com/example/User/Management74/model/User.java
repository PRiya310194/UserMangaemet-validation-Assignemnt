package com.example.User.Management74.model;


import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
@Data
@Entity
@Table(name="tbl_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="user_id")
    @NotNull(message="userId should not be empty")
    private Integer userId;
    @NotNull(message="user_name should not be empty" )
    @Column(name="name")
    private String name;
    @NotNull(message="Date should not be empty")
    @Column(name="Date")
private Date date;
    @NotEmpty(message="please enter valid EmailId")
    @Column(name="email")
private String email;
    @Column(name="phoneNumber")
    @Length(min=10, max=12,message="please enter valid email id ")
private String phoneNumber;
    @Column(name="Time")
    @NotBlank(message="time should not be empty")
private String time;
    @NotNull(message="DateOfBirth should not be empty")
    @Column(name="DateOfBirth")
    @DateTimeFormat(pattern = "YYYY-MM-DD")
private String dateOfBirth;



}
