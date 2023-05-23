package com.crazyemperor.homework35loggingtransactional.service.user;

import com.crazyemperor.homework35loggingtransactional.entity.User;

public interface UserService {

    User add(User user);

    void delete(String name);
}
