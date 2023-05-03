package com.karan.app.crud.Controller;

import com.karan.app.crud.Models.User;
import com.karan.app.crud.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {
    @Autowired
    private UserRepo userRepo;


    @GetMapping(value = "/")
    public String getPage(){
        return "Welcome";
    }

    @GetMapping(value = "/users")
    public List<User> getUsers(){
        return userRepo.findAll();
    }

    @PostMapping(value = "/save")
    public String saveUsers(@RequestBody User user){
        userRepo.save(user);
        return "SAVED";
    }

    @PutMapping(value = "update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user){
        User updateUser = userRepo.findById(id).get();
        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        updateUser.setAge(user.getAge());
        updateUser.setOccupation(user.getOccupation());
        userRepo.save(updateUser);
        return "UPDATED";
    }

    @DeleteMapping(value = "delete/{id}")
    public String deleteUser(@PathVariable long id){
        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return "DELETED user at " + id;
    }
}
