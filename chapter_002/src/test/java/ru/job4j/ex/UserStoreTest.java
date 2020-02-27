package ru.job4j.ex;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserStoreTest {
    User[] users = {
            new User("Petr Arsentev", true),
            new User("Invalid user", false),
            new User("xx", true)
    };

    @Test
    public void userFoundedAndValid() {
        try {
            User user = UserStore.findUser(users, "Petr Arsentev");
            boolean result = UserStore.validate(user);
            assertTrue(result);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = UserNotFoundException.class)
    public void userNotFound() throws UserNotFoundException {
        UserStore.findUser(users, "none");
    }

    @Test(expected = UserInvalidException.class)
    public void userFoundButInvalid() throws UserInvalidException {
        User user = null;
        try {
            user = UserStore.findUser(users, "Invalid user");
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        UserStore.validate(user);
    }

    @Test(expected = UserInvalidException.class)
    public void userInvalidWithShortName() throws UserInvalidException {
        User user = null;
        try {
            user = UserStore.findUser(users, "xx");
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        UserStore.validate(user);
    }

}