package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("new@mail.ru", "New user");
        map.put("test@yandex.ru", "Test user");
        map.put("admin@google.ru", "Admin");
        map.put("new@mail.ru", "New new user");

        for (String mail : map.keySet()) {
            System.out.println("E-mail: " + mail + ", name: " + map.get(mail));
        }
    }
}
