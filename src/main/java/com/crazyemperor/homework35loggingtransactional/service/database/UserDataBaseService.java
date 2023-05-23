package com.crazyemperor.homework35loggingtransactional.service.database;

import com.crazyemperor.homework35loggingtransactional.entity.User;

import java.util.List;

public interface UserDataBaseService {

    List<User> getUser();

    User addUser(User user);

    User userIsDeletedByNickname(String nickname);
}
