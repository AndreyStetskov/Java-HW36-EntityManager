package com.crazyemperor.homework35loggingtransactional.repository;

import com.crazyemperor.homework35loggingtransactional.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User deleteByNickname(String nickname);

}
