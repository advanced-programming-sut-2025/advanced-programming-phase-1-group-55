package controller;

import Controller.RegisterController;
import model.Result;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RegisterControllerTest {

    @Test
    public void testSuccessfulRegistration() {
        RegisterController controller = new RegisterController();
        Result result = controller.Register(
                "user123",
                "StrongP@ss1",
                "StrongP@ss1",
                "nickname",
                "user@example.com",
                "male"
        );

        assertFalse(result.IsSuccess());
        assertEquals("Password is not valid", result.Message());
    }

    @Test
    public void testInvalidUsername() {
        RegisterController controller = new RegisterController();
        Result result = controller.Register(
                "user@@@",
                "StrongP@ss1",
                "StrongP@ss1",
                "nickname",
                "user@example.com",
                "male"
        );

        assertFalse(result.IsSuccess());
        assertEquals("username is not valid", result.Message());
    }

    @Test
    public void testInvalidEmail() {
        RegisterController controller = new RegisterController();
        Result result = controller.Register(
                "user123",
                "StrongP@ss1",
                "StrongP@ss1",
                "nickname",
                "invalid-email",
                "male"
        );

        assertFalse(result.IsSuccess());
        assertEquals("Email is not valid", result.Message());
    }

    @Test
    public void testPasswordMismatch() {
        RegisterController controller = new RegisterController();
        Result result = controller.Register(
                "user123",
                "StrongP@ss1",
                "WrongP@ss1",
                "nickname",
                "user@example.com",
                "male"
        );

        assertFalse(result.IsSuccess());
        assertEquals("Passwords do not match", result.Message());
    }

    @Test
    public void testWeakPassword() {
        RegisterController controller = new RegisterController();
        Result result = controller.Register(
                "user123",
                "weakpass",
                "weakpass",
                "nickname",
                "user@example.com",
                "male"
        );

        assertFalse(result.IsSuccess());
        assertEquals("Password is not strong", result.Message());
    }
}
