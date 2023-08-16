package com.example.hw17.Controller;

import com.example.hw17.ApiResponse.ApiResponse;
import com.example.hw17.Model.UserModel;
import com.example.hw17.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity get(){
        return ResponseEntity.status(200).body(userService.get());
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid UserModel userModel,Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.add(userModel);
        return ResponseEntity.status(200).body(new ApiResponse("added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id,@RequestBody @Valid UserModel userModel, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if (userService.update(id, userModel)){
            return ResponseEntity.status(200).body(new ApiResponse("updated"));
        }return ResponseEntity.status(400).body(new ApiResponse("not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        if (userService.delete(id)){
            return ResponseEntity.status(200).body(new ApiResponse("delete"));
        }return ResponseEntity.status(400).body(new ApiResponse("not found"));
    }





}
