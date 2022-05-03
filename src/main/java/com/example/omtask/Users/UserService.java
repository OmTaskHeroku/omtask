package com.example.omtask.Users;

import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        if (user == null) throw new UsernameNotFoundException("User ont found in the database");

        SimpleGrantedAuthority authorities = null;
        authorities = new SimpleGrantedAuthority(user.getRole().getName());

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Collections.singleton(authorities));
    }

    public Role saveRole(Role role){ return roleRepository.save(role);}

    public User saveUser(User user){ return userRepository.save(user);}

    public void addRoleToUser(String username,String roleName){
        User user = userRepository.findByUsername(username);
        user.setRole(roleRepository.findByName(roleName));
        userRepository.save(user);}

}
