package com.ftwitter.services;

import com.ftwitter.models.ApplicationUser;
import com.ftwitter.models.Role;
import com.ftwitter.repositories.RoleRepository;
import com.ftwitter.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {
    private final UserRepository userRepo;
    private final RoleRepository roleRepo;

    @Autowired
    public UserService(UserRepository userRepo, RoleRepository roleRepo){
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    public ApplicationUser registerUser(ApplicationUser user){
        Set<Role> roles = user.getAuthorities();
        roles.add(roleRepo.findByAuthority("USER").get());
        user.setAuthorities(roles);

        return userRepo.save(user);
    }
}
