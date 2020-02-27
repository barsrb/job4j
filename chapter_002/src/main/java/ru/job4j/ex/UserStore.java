package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User founded = null;
        for (User user : users) {
            if (user.getUsername().equals(login)) {
                founded = user;
            }
        }
        if (founded == null) {
            throw new UserNotFoundException("User " + login + " was not found!");
        }
        return founded;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid()) {
            throw new UserInvalidException("User " + user.getUsername() + " not valid!");
        }
        if (user.getUsername().length() < 3) {
            throw new UserInvalidException("Username length less then 3: " + user.getUsername());
        }
        return true;
    }

}