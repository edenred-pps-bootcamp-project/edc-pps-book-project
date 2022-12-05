package com.edc.pps.catalog.service;

import com.edc.pps.catalog.dto.UserRequest;
import com.edc.pps.catalog.dto.UserResponse;
import com.edc.pps.catalog.exception.UserAlreadyRegisteredException;
import javassist.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class UserServiceIntegrationTest {

    @Autowired
    private UserService userService;


    @BeforeEach
    void setup() {
        userService.findAll().forEach(userResponse -> userService.delete(userResponse.getId()));
    }

    @Test
    void givenUserRequest_whenSave_thenReturnPaperResponse()  {
        //given
        UserRequest request = new UserRequest();
        request.setFirstName("Andrei");
        request.setLastName("Popescu");
        request.setUserName("andreip01");

        //when
        UserResponse actual = null;
        try {
            actual = userService.save(request);
        } catch (UserAlreadyRegisteredException e) {
            throw new RuntimeException(e);
        }

        UserResponse expected = new UserResponse();
        expected.setId(actual.getId());
        expected.setFirstName("Andrei");
        expected.setLastName("Popescu");
        expected.setUserName("andreip01");

        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getFirstName()).isEqualTo(expected.getFirstName());
        assertThat(actual.getLastName()).isEqualTo(expected.getLastName());
        assertThat(actual.getUserName()).isEqualTo(expected.getUserName());

    }

    @Test
    void givenUser_whenUpdate_thenReturnUpdatedUser()  {
        //given
        UserRequest request = new UserRequest();
        request.setFirstName("Andrei");
        request.setLastName("Popescu");
        request.setUserName("andreip01");

        UserResponse savedUser = null;
        try {
            savedUser = userService.save(request);
        } catch (UserAlreadyRegisteredException e) {
            throw new RuntimeException(e);
        }

        UserRequest updateUser = new UserRequest();
        updateUser.setFirstName("Mihai");
        updateUser.setLastName("Popa");
        updateUser.setUserName("mihaip01");

        //when
        UserResponse actual = null;
        try {
            actual = userService.update(savedUser.getId(), updateUser);
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }

        //then
        assertThat(actual.getUserName()).isEqualTo(updateUser.getUserName());
    }

    @Test
    void givenUser_whenDelete_thenIsEmpty()  {
        //given

        UserRequest request = new UserRequest();
        request.setFirstName("Andrei");
        request.setLastName("Popescu");
        request.setUserName("andreip01");

        UserResponse savedUser = null;
        try {
            savedUser = userService.save(request);
        } catch (UserAlreadyRegisteredException e) {
            throw new RuntimeException(e);
        }
        int sizeBefore = userService.findAll().size();

        //when
        userService.delete(savedUser.getId());
        int sizeAfter = userService.findAll().size();

        //then
        assertThat(sizeBefore).isGreaterThan(sizeAfter);
    }

    @Test
    void givenValidId_whenFindById_thenReturnResponse()  {
        //given
        UserRequest request = new UserRequest();
        request.setFirstName("Andrei");
        request.setLastName("Popescu");
        request.setUserName("andreip01");

        UserResponse savedUser = null;
        try {
            savedUser = userService.save(request);
        } catch (UserAlreadyRegisteredException e) {
            throw new RuntimeException(e);
        }

        //when
        UserResponse actual = null;
        try {
            actual = userService.findById(savedUser.getId());
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }

        //then
        assertThat(actual.getUserName()).isEqualTo(request.getUserName());

    }


    @Test
    void given2Papers_whenFindAll_thenReturn2Responses()  {
        //given
        UserRequest request1 = new UserRequest();
        request1.setFirstName("Andrei");
        request1.setLastName("Popescu");
        request1.setUserName("andreip01");

        UserRequest request2 = new UserRequest();
        request2.setFirstName("Andreea");
        request2.setLastName("Popa");
        request2.setUserName("andreeap01");

        try {
            userService.save(request1);
        } catch (UserAlreadyRegisteredException e) {
            throw new RuntimeException(e);
        }
        try {
            userService.save(request2);
        } catch (UserAlreadyRegisteredException e) {
            throw new RuntimeException(e);
        }

        //when
        List<UserResponse> actual = userService.findAll();

        //then
        assertThat(actual).hasSize(2);
    }
}