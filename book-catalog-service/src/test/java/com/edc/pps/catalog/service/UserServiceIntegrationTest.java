package com.edc.pps.catalog.service;

import com.edc.pps.catalog.dto.UserRequest;
import com.edc.pps.catalog.dto.UserResponse;
import com.edc.pps.catalog.exception.UserFailedToBeRegisteredException;
import javassist.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class UserServiceIntegrationTest {

    @Autowired
    private UserService userService;


    @BeforeEach
    void setup() {
        userService.findAll().forEach(userResponse -> userService.delete(userResponse.getId()));
    }

    @Test
    void givenUserRequest_whenSave_thenReturnPaperResponse() throws UserFailedToBeRegisteredException {
        //given
        UserRequest request = new UserRequest();
        request.setFirstName("Andrei");
        request.setLastName("Popescu");
        request.setUserName("andreip01");

        //when
        UserResponse actual = userService.save(request);

        assertThat(actual).usingRecursiveComparison().ignoringFields("id").isEqualTo(request);
        assertNotNull(actual.getId());

    }

    @Test
    void givenUser_whenUpdate_thenReturnUpdatedUser() throws NotFoundException {
        //given
        UserRequest request = new UserRequest();
        request.setFirstName("Andrei");
        request.setLastName("Popescu");
        request.setUserName("andreip01");

        UserResponse savedUser = null;
        try {
            savedUser = userService.save(request);
        } catch (UserFailedToBeRegisteredException e) {
            throw new RuntimeException(e);
        }

        UserRequest updateUser = new UserRequest();
        updateUser.setFirstName("Mihai");
        updateUser.setLastName("Popa");
        updateUser.setUserName("mihaip01");

        //when
        UserResponse actual = userService.update(savedUser.getId(), updateUser);


        //then
        assertThat(actual.getUserName()).isEqualTo(updateUser.getUserName());
    }

    @Test
    void givenUser_whenDelete_thenIsEmpty() throws UserFailedToBeRegisteredException {
        //given

        UserRequest request = new UserRequest();
        request.setFirstName("Andrei");
        request.setLastName("Popescu");
        request.setUserName("andreip01");

        UserResponse savedUser =  userService.save(request);

        int sizeBefore = userService.findAll().size();

        //when
        userService.delete(savedUser.getId());
        int sizeAfter = userService.findAll().size();

        //then
        assertThat(sizeBefore).isGreaterThan(sizeAfter);
    }

    @Test
    void givenId_whenFindById_thenReturnResponse() throws UserFailedToBeRegisteredException, NotFoundException {
        //given
        UserRequest request = new UserRequest();
        request.setFirstName("Andrei");
        request.setLastName("Popescu");
        request.setUserName("andreip01");

        UserResponse savedUser = userService.save(request);

        //when
        UserResponse actual = userService.findById(savedUser.getId());


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
        } catch (UserFailedToBeRegisteredException e) {
            throw new RuntimeException(e);
        }
        try {
            userService.save(request2);
        } catch (UserFailedToBeRegisteredException e) {
            throw new RuntimeException(e);
        }

        //when
        List<UserResponse> actual = userService.findAll();

        //then
        assertThat(actual).hasSize(2);
    }


}