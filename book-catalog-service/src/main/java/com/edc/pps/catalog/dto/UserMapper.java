package com.edc.pps.catalog.dto;

import com.edc.pps.catalog.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public List<UserResponse> toDto(List<User> users) {
        return users.stream().map(this::toDto).collect(Collectors.toList());
    }

    public UserResponse toDto(User user) {
        UserResponse dto = new UserResponse();
        dto.setUserId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setUserName(user.getUserName());
        dto.setCatalogItems(user.getCatalogItems());

        return dto;
    }

    public List<User> toEntity(List<UserRequest> userRequests){
        return userRequests.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public User toEntity(UserRequest userRequest) {
        User entity = new User();

        entity.setLastName(userRequest.getLastName());
        entity.setFirstName(userRequest.getFirstName());
        entity.setUserName(userRequest.getUserName());
        entity.setId(userRequest.getUserId());
        entity.setCatalogItems(userRequest.getCatalogItems());

        return entity;
    }
}
