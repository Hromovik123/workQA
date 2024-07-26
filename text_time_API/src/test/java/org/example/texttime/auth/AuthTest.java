package org.example.texttime.auth;

import org.example.texttime.model.dto.UserDto;
import org.example.texttime.service.AuthService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class AuthTest {

    @Mock
    private AuthService authService;

    @InjectMocks
    private AuthController authController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateUser() {
        //Prepare
        UserDto userDto = new UserDto(); // You need to create a UserDto object with required data
        when(authService.createUser(userDto)).thenReturn(123); // Mock the return value

        // Execute
        Integer userId = authController.createUser(userDto);

        // Verify
        assertEquals(123, userId); // Verify that the controller returns the expected user ID
        verify(authService, times(1)).createUser(userDto); // Verify that the service method was called once
    }

    @Test
    public void testGetUserById() {
       // Prepare
        int userId = 123; // Specify a user ID
        UserDto userDto = new UserDto(); // You need to create a UserDto object with required data
        when(authService.getUserById(userId)).thenReturn(userDto); // Mock the return value

        // Execute
        UserDto resultUserDto = authController.getUser(userId);

        // Verify
        assertEquals(userDto, resultUserDto); // Verify that the controller returns the expected UserDto
        verify(authService, times(1)).getUserById(userId); // Verify that the service method was called once
    }

    @Test
    public void testLogin() {
        // Prepare
        UserDto userDto = new UserDto(); // You need to create a UserDto object with required data

        // Execute
        String result = authController.login(userDto);

        // Verify
        assertEquals("Hello world", result); // Verify that the controller returns the expected string
    }

    @Test
    public void testValidPassword() {
        // Prepare
        String requestBody = "some request body"; // Specify a request body

        // Execute
        Object result = authController.validPassword(requestBody);

        // Verify
        assertNotNull(result); // Verify that the controller returns a non-null object
        assertEquals(Object.class, result.getClass()); // Verify that the returned object is of type Object
    }
}


