package com.crazyemperor.homework35loggingtransactional.controller;

import com.crazyemperor.homework35loggingtransactional.entity.Sex;
import com.crazyemperor.homework35loggingtransactional.entity.User;
import com.crazyemperor.homework35loggingtransactional.service.newpartner.NewPartnerService;
import com.crazyemperor.homework35loggingtransactional.service.user.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
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

    @PersistenceContext
    private final EntityManager entityManager;


    @GetMapping(value = "/new-match")
    public ResponseEntity<User> getNewMatch() {
        User user = newPartnerService.getNewMatch();

        return user != null ? ResponseEntity.ok(user) : ResponseEntity.badRequest().build();
    }

    @GetMapping(value = "/new-user")
    public ResponseEntity<User> add(User user) {
        return ResponseEntity.ok(user);
    }

    @DeleteMapping(value = "/user_delete/{name}")
    public void deleteUser(@PathVariable String name) {

        userService.delete(name);
    }

    @GetMapping(value = "/new-two-user")
    public void addTwoUsers() {

        User userOne = new User();
        userOne.setNickname("Ernst Handel");
        userOne.setAge(25);
        userOne.setSex(Sex.INTERSEX);
        userOne.setCity("Portugal");
        entityManager.persist(userOne);

        User userTwo = new User();
        userTwo.setNickname("Folk och fä HB");
        userTwo.setFirstName("Maria");
        userTwo.setAge(25);
        userTwo.setSex(Sex.FEMALE);
        userTwo.setCity("Bräcke");
        userTwo.setCity("Sweden");
        entityManager.persist(userTwo);
    }
}
