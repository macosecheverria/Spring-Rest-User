package com.rest.server.users;

import com.rest.server.users.Entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping
    public ResponseEntity<Users> createUser(@RequestBody Users user){
        Users createUser = this.usersService.create(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(createUser);
    }

    @GetMapping
    public ResponseEntity<List<Users>> findAllUsers(){
        return ResponseEntity.ok(this.usersService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Users> findOneUser(@PathVariable Long id){
        Users userId = this.usersService.findOne(id);
        return ResponseEntity.ok(userId);
    }


    @PutMapping("{id}")
    public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody Users user){
        Users userUpdate = this.usersService.update(id, user);
        return ResponseEntity.ok(userUpdate);
    }

    @DeleteMapping("{id}")
    public void removeUser(@PathVariable Long id){
        this.usersService.remove(id);
    }
}
