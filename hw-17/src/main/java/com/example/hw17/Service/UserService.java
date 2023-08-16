package com.example.hw17.Service;

import com.example.hw17.Model.UserModel;
import com.example.hw17.Repostries.User;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
private  final User user;

public List<UserModel> get(){
    return user.findAll();
}

public void add(UserModel userModel){
    user.save(userModel);
}

public Boolean update(Integer id ,UserModel userModel){
    UserModel userId = user.getById(id);
    if (userId==null){
        return false;
    }
    userId.setName(userModel.getName());
    userId.setUsername(userModel.getUsername());
    userId.setPassword(userModel.getPassword());
    userId.setEmail(userModel.getEmail());
    userId.setRole(userModel.getRole());
    userId.setAge(userId.getAge());
    user.save(userId);
    return true;
}

    public Boolean delete(Integer id){
        UserModel userId = user.getById(id);
        if (userId==null){
            return false;
        }
        user.delete(userId);
        return true;
}


}
