package com.crazyemperor.homework35loggingtransactional.service.database.implementation;

import com.crazyemperor.homework35loggingtransactional.entity.User;
import com.crazyemperor.homework35loggingtransactional.repository.UserRepository;
import com.crazyemperor.homework35loggingtransactional.service.database.UserDataBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DataBaseServiceImpl implements UserDataBaseService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User userIsDeletedByNickname(String nickname) {
        return userRepository.deleteByNickname(nickname);
    }


}
