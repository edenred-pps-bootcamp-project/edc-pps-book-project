package com.edc.pps.catalog.service;

import com.edc.pps.catalog.dto.CatalogItem;
import com.edc.pps.catalog.dto.UserMapper;
import com.edc.pps.catalog.dto.UserRequest;
import com.edc.pps.catalog.dto.UserResponse;
import com.edc.pps.catalog.dto.info.BookMapper;
import com.edc.pps.catalog.exception.UserAlreadyRegisteredException;
import com.edc.pps.catalog.model.User;
import com.edc.pps.catalog.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private static UserRepository userRepository;
    @Mock
    private static BookService bookService;
    @Mock
    private static RatingService ratingService;
    @Mock
    private static UserMapper userMapper;
    @Mock
    private static BookMapper bookMapper;


    private static UserService userService;


    @BeforeAll
    public static void setup() {

        userRepository = mock(UserRepository.class);
        userService = new UserService(userRepository, bookService, ratingService, userMapper);

    }


    /*
    @Test
    void givenUser_whenCreate_thenReturnUserResponse(){
        // given

        List<CatalogItem> catalogItems = new ArrayList<>();

        UserRequest userRequest = new UserRequest();

        userRequest.setFirstName("Popescu");
        userRequest.setLastName("Andrei");
        userRequest.setUserName("andreip");
        userRequest.setCatalogItems(catalogItems);

        // when
        UserResponse actualUser = userService.save(userRequest);

        // then
        assertThat(actualUser.getId()).isNotNull();

    }*/
/*
    @Test
    void findAll() throws UserAlreadyRegisteredException {

        // given

        List<User> mockUsers = new ArrayList<>();

        User user = new User();
        user.setId(1L);
        user.setFirstName("Popescu");
        user.setLastName("Andrei");
        user.setUserName("andreip");
        List<CatalogItem> catalogItems = new ArrayList<>();
        user.setCatalogItems(catalogItems);
        mockUsers.add(user);

        UserRequest userRequest = new UserRequest();

        userRequest.setFirstName("Popescu");
        userRequest.setLastName("Andrei");
        userRequest.setUserName("andreip");
        userRequest.setCatalogItems(catalogItems);

        userService.save(userRequest);


        //MOCK ALERT: return mocked result set on find
        when(userRepository.findAll()).thenReturn(mockUsers);

        //call the method we want to test
        List<UserResponse> actual = userService.findAll();

        //MOCK ALERT : verify the method was called
        verify(userRepository).findAll();

        assertEquals(null, actual);
    }
*/
}