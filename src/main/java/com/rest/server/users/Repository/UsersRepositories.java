package com.rest.server.users.Repository;

import com.rest.server.users.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepositories extends JpaRepository<Users, Long> {
}
