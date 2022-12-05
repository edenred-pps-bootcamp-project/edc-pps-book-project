package com.edc.pps.catalog.service;

import com.edc.pps.catalog.dto.CatalogItem;
import com.edc.pps.catalog.dto.UserMapper;
import com.edc.pps.catalog.dto.UserRequest;
import com.edc.pps.catalog.dto.UserResponse;
import com.edc.pps.catalog.exception.UserAlreadyRegisteredException;
import com.edc.pps.catalog.model.User;
import com.edc.pps.catalog.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceUnitTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserService userService;

    @Test
    void givenUserRequest_whenSave_thenReturnUserResponse() throws UserAlreadyRegisteredException {
        //given
        List<CatalogItem> catalogItemList = new ArrayList<>();
        UserRequest request = new UserRequest();
        request.setFirstName("Andrei");
        request.setLastName("Popescu");
        request.setUserName("andreip01");
        request.setCatalogItems(catalogItemList);

        User mockUser = new User();
        mockUser.setFirstName("Andrei");
        mockUser.setLastName("Popescu");
        mockUser.setUserName("andreip01");
        mockUser.setCatalogItems(catalogItemList);

        UserResponse response = new UserResponse();
        response.setFirstName("Andrei");
        response.setLastName("Popescu");
        response.setUserName("andreip01");
        response.setCatalogItems(catalogItemList);

        when(userMapper.toEntity(request)).thenReturn(mockUser);
        when(userRepository.save(mockUser)).thenReturn(mockUser);
        when(userMapper.toDto(mockUser)).thenReturn(response);

        UserResponse actual = userService.save(request);

        assertThat(actual).isEqualTo(response);
    }

    @Test
    void given2Users_whenFindAll_thenReturn2Responses() {
        //given
        List<CatalogItem> catalogItemList = new ArrayList<>();

        List<User> userList = new ArrayList<>();

        User mockUser1 = new User();
        mockUser1.setId(1L);
        mockUser1.setFirstName("Andrei");
        mockUser1.setLastName("Popescu");
        mockUser1.setUserName("andreip01");
        mockUser1.setCatalogItems(catalogItemList);
        userList.add(mockUser1);

        User mockUser2 = new User();
        mockUser2.setId(2L);
        mockUser2.setFirstName("Andreea");
        mockUser2.setLastName("Popa");
        mockUser2.setUserName("andreeap01");
        mockUser2.setCatalogItems(catalogItemList);
        userList.add(mockUser2);


        List<UserResponse>  userResponseList= new ArrayList<>();
        UserResponse response1 = new UserResponse();
        response1.setFirstName("Andrei");
        response1.setLastName("Popescu");
        response1.setUserName("andreip01");
        response1.setCatalogItems(catalogItemList);
        userResponseList.add(response1);


        UserResponse response2 = new UserResponse();
        response2.setFirstName("Andreea");
        response2.setLastName("Popa");
        response2.setUserName("andreeap01");
        response2.setCatalogItems(catalogItemList);
        userResponseList.add(response2);


        when(userRepository.findAll()).thenReturn(Arrays.asList(mockUser1,mockUser2));
        when(userMapper.toDto(any(User.class))).thenReturn(response1,response2);
        //when(userMapper.toDto(userList)).thenReturn(userResponseList);


        //when
        List<UserResponse> actual = userService.findAll();

        //then
        assertThat(actual).hasSize(2);
       // System.out.println(actual);

    }
}
