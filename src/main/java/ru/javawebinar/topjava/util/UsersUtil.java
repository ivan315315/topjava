package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.User;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static ru.javawebinar.topjava.model.Role.*;

public class UsersUtil {
    public static final List<User> userList;
    static {
        userList = Arrays.asList(
                new User("Ivan1", "Ivan1@mail.ru", "12345", ROLE_USER),
                new User("Ivan3", "Ivan2@mail.ru", "12345", ROLE_USER),
                new User("Ivan3", "Ivan3@mail.ru", "12345", ROLE_USER, ROLE_ADMIN)
        );
    }

    public static List<User> filtred() {
        return userList.stream().sorted((user1 , user2) -> Integer.compare(user1.getId(), user2.getId())).collect(Collectors.toList());
    }
}
