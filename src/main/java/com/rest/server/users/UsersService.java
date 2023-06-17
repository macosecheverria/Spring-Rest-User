package com.rest.server.users;

import com.rest.server.common.Exception.NotFoundException;
import com.rest.server.users.Entity.Users;
import com.rest.server.users.Repository.UsersRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    private UsersRepositories usersRepositories;


    public Users create(Users user){
        return this.usersRepositories.save(user);
    }

    public List<Users> getAllUsers(){
        return this.usersRepositories.findAll();
    }

    public Users getOneById(Long id){
        return this.usersRepositories.findById(id).orElseThrow(
                () -> new NotFoundException("User with id: " + id + "not found")
        );

    }

}
