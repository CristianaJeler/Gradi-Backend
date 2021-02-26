package com.gradi.app.user.repository;

import com.gradi.app.user.model.UserEntity;
import com.gradi.app.user.model.UserEntityDTO;
import com.gradi.app.user.model.UserSignupDTO;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
        @Modifying
        @Transactional
        @Query("update UserEntity user set user.token=:token where user.username=:username")
        void setToken(String token, String username);


        boolean existsByEmail(String email);
        boolean existsByUsername(String username);

        UserEntity findByUsernameAndPassword(String username, String password);

        UserEntity findByUsername(String username);

        UserEntity findUserEntityByToken(String token);
}
