package com.rest.server.users;

import com.rest.server.users.Entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping
    public Users createUser(@RequestBody Users user){
        return this.usersService.create(user);
    }

    @GetMapping
    public ResponseEntity<List<Users>> getAll(){
        return ResponseEntity.ok(this.usersService.getAllUsers());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Long id){
        return this.getUserById(id);
    }

}
