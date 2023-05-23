package com.crazyemperor.homework35loggingtransactional.service.newpartner.implementation;

import com.crazyemperor.homework35loggingtransactional.entity.User;
import com.crazyemperor.homework35loggingtransactional.service.database.UserDataBaseService;
import com.crazyemperor.homework35loggingtransactional.service.newpartner.NewPartnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class RandomNewPartnerService implements NewPartnerService {

    private final UserDataBaseService userDataBaseService;


    @Override
    @CachePut(value = "USERS", key = "#id")
    @Transactional(noRollbackFor = RuntimeException.class)
    public User getNewMatch() {
        Random random = new Random();

        List<User> users = userDataBaseService.getUser();

        int i = random.nextInt(users.size());

        return users.get(i);
    }

}
