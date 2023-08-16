package com.example.hw17.Repostries;


import com.example.hw17.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User extends JpaRepository<UserModel,Integer> {

}
