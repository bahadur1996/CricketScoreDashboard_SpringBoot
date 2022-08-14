package com.backendcode.assignment.mapper;

import com.backendcode.assignment.entity.ItemEntity;
import com.backendcode.assignment.entity.UserEntity;
import com.backendcode.assignment.model.Item;
import com.backendcode.assignment.model.Role;
import com.backendcode.assignment.model.User;
import com.backendcode.assignment.repository.ChannelRepository;
import com.backendcode.assignment.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final RoleRepository roleRepository;

    public EntityModelMapper<UserEntity, User> entityToModel(){
        return entity-> new User()
                .setId(entity.getId())
                .setActive(entity.getActive())
                .setEmail(entity.getEmail())
                .setUserName(entity.getUserName())
                .setPassword(entity.getPassword())
                .setName(entity.getName())
                .setRoles(entity.getRoles().stream().map(roleEntity -> new Role().setRole(roleEntity.getRole()).setId(roleEntity.getId())).collect(Collectors.toSet()))
                .setLastName(entity.getLastName());
    }

    public EntityModelMapper<User, UserEntity> modelToEntity(){
        return model -> new UserEntity()
                .setId(model.getId())
                .setActive(model.getActive())
                .setEmail(model.getEmail())
                .setUserName(model.getUserName())
                .setPassword(model.getPassword())
                .setName(model.getName())
                .setRoles(new HashSet(roleRepository.findAll()))
                .setLastName(model.getLastName());
    }
}
