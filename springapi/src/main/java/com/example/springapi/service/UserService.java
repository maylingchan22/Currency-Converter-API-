package com.example.springapi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.List;

import org.springframework.stereotype.Service;
import com.example.springapi.api.model.User;

@Service
public class UserService {

    private List<User> userList;

    public UserService() {
        userList = new ArrayList<>();

        User user1 = new User(1, "Ida", 32, "ida@gmail.com");
        User user2 = new User(1, "Fred", 32, "fred@gmail.com");
        User user3 = new User(1, "Jack", 32, "jack@gmail.com");
        User user4 = new User(1, "Jan", 32, "jan@gmail.com");
        User user5 = new User(1, "San", 32, "san@gmail.com");

        userList.addAll(Arrays.asList(user1, user2, user3, user4, user5));

    }

    public Optional<User> getUser(Integer id) {
        Optional<User> optional = Optional.empty();
        for (User user : userList) {
            if (id == user.getId()) {
                optional = Optional.of(user);
                return optional;
            }
        }
        return optional;
    }
}
