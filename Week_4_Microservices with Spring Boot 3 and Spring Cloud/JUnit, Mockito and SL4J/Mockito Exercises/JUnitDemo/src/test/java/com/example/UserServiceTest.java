package com.example;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

public class UserServiceTest {

    @Test
    void testRegisterUser() {

        EmailService mockEmailService = mock(EmailService.class);

        UserService userService = new UserService(mockEmailService);

        userService.registerUser("saiabhiram@example.com");

        verify(mockEmailService).sendEmail("saiabhiram@example.com");
    }
}
