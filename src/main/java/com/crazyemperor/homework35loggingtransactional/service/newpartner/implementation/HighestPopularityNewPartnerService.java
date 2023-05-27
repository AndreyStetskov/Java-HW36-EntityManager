package com.crazyemperor.homework35loggingtransactional.service.newpartner.implementation;

import com.crazyemperor.homework35loggingtransactional.entity.User;
import com.crazyemperor.homework35loggingtransactional.service.database.UserDataBaseService;
import com.crazyemperor.homework35loggingtransactional.service.newpartner.NewPartnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Primary
@Slf4j
public class HighestPopularityNewPartnerService implements NewPartnerService {

    private final UserDataBaseService userDataBaseService;


    @Override
    @Cacheable(value = "USERS", key = "#id")
    @Transactional(noRollbackFor = RuntimeException.class)
    public User getNewMatch() {
        List<User> users = userDataBaseService.getUser();

        User highestPointer = null;

        int maxPoint = 0;

        log.info("Looking for a partner for you");

        for (User user : users) {
            if (user.getPoint() > maxPoint) {
                maxPoint = user.getPoint();
                highestPointer = user;
            }
        }

        return highestPointer;
    }
}
