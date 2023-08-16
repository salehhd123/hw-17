package com.example.hw17.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class UserModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Size(min = 5)
    @Column(columnDefinition = "varchar(20) not null")
    private  String name;

    @NotEmpty
    @Size(min = 5)
    @Column(columnDefinition = "varchar(20) not null")
    private  String username;

    @NotEmpty
    @Column(columnDefinition = "varchar(20) not null")
    private String password;

    @NotEmpty
    @Email
    @Column(columnDefinition = "varchar(30) unique not null")
    private String email;

    @NotEmpty
    @Pattern(regexp = "(user|admin)")
    @Column(columnDefinition = "varchar(30) not null")
    private String role;

    @NotNull
    @Column(columnDefinition = "int not null")
    private Integer age;


}
