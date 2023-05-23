package com.crazyemperor.homework35loggingtransactional.service.user.implementation;

import com.crazyemperor.homework35loggingtransactional.entity.User;
import com.crazyemperor.homework35loggingtransactional.service.database.UserDataBaseService;
import com.crazyemperor.homework35loggingtransactional.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDataBaseService userDataBaseService;

    @Override
    @CacheEvict(value = "USERS", key = "#id")
    @Transactional
    public User add(User user) {
        log.info("Now create a new user");

        user.setNickname("IslandTrading");
        user.setFirstName("Helen");
        user.setLastName("Bennett");
        user.setCountry("Belgium");
        user.setPoint(0);
        user.setBlocked(false);

        return userDataBaseService.addUser(user);
    }

    @Override
    public void delete(String nickname) {

        log.info("Are you sure you want to delete this user?");
        userDataBaseService.userIsDeletedByNickname(nickname);
    }
}
