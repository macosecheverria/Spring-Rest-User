package com.rest.server.users;

import com.rest.server.common.Exception.NotFoundException;
import com.rest.server.users.Entity.Users;
import com.rest.server.users.Repository.UsersRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    @Autowired
    private UsersRepositories usersRepositories;


    public Users create(Users user){
        return this.usersRepositories.save(user);
    }

    public List<Users> findAll(){
        return this.usersRepositories.findAll();
    }

    public Users findOne(Long id){
       Users user = this.usersRepositories.findById(id).orElseThrow(
               () -> new NotFoundException("User whit id" + id + "not found")
       );

       return user;
    }


    public Users update(Long id, Users userUpdate){
        Users user = this.findOne(id);

        user.setName(userUpdate.getName());
        return this.usersRepositories.save(user);
    }


    public void remove(Long id){
        Users user = this.findOne(id);
        this.usersRepositories.delete(user);
    }

}
