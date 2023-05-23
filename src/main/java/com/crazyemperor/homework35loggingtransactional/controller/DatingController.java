package com.crazyemperor.homework35loggingtransactional.controller;

import com.crazyemperor.homework35loggingtransactional.entity.User;
import com.crazyemperor.homework35loggingtransactional.service.newpartner.NewPartnerService;
import com.crazyemperor.homework35loggingtransactional.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class DatingController {

    private final NewPartnerService newPartnerService;

    private final UserService userService;


    @GetMapping(value = "/new-match")
    public User newMatch() {

        log.info("Looking for a partner for you");
        return newPartnerService.getNewMatch();
    }

    @GetMapping(value = "/new-user")
    public User add(User user) {
        log.info("The user is being created");
        return userService.add(user);
    }

    @DeleteMapping(value = "/user_delete/{name}")
    public void deleteUser(@PathVariable String name) {

        log.info("The user is being deleted");
        userService.delete(name);
    }

}
