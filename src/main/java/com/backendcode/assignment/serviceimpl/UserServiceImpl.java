package com.backendcode.assignment.serviceimpl;

import com.backendcode.assignment.entity.RoleEntity;
import com.backendcode.assignment.entity.UserEntity;
import com.backendcode.assignment.mapper.UserMapper;
import com.backendcode.assignment.model.User;
import com.backendcode.assignment.repository.RoleRepository;
import com.backendcode.assignment.repository.UserRepository;
import com.backendcode.assignment.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(true);
        UserEntity userEntity = userRepository.save(userMapper.modelToEntity().map(user));
        return userMapper.entityToModel().map(userEntity);
    }

    @Override
    public void createAdminUser() {
        if (userRepository.findByUserName("admin") != null) {
            return;
        }

        RoleEntity roleEntity = roleRepository.save(new RoleEntity().setRole("ADMIN"));
        UserEntity userEntity = new UserEntity()
                .setActive(true)
                .setEmail("admin@gmail.com")
                .setUserName("admin")
                .setPassword(passwordEncoder.encode("admin"))
                .setName("admin")
                .setRoles(new HashSet(Arrays.asList(roleEntity)))
                .setLastName("admin");
        userRepository.save(userEntity);
    }

    public User getUserByEmail(String email) {
        UserEntity userEntity = userRepository.findByEmail(email);
        return userMapper.entityToModel().map(userEntity);
    }

    @Override
    public User getdUserByUserName(String userName) {
        UserEntity userEntity = userRepository.findByUserName(userName);
        return userMapper.entityToModel().map(userEntity);
    }

}
