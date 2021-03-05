package com.gradi.app.user.repository;

import com.gradi.app.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Blob;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
        @Modifying
        @Transactional
        @Query("update UserEntity user set user.token=:token where user.username=:username")
        void setToken(String token, String username);

        @Modifying
        @Transactional
        @Query("update UserEntity user set user.picture=:picture where user.token=:token")
        void updateProfilePic(byte[] picture, String token);

        @Modifying
        @Transactional
        @Query("update UserEntity user set user.lastName=:lastName where user.id=:id")
        void updateLastName(String lastName, String id);


        @Modifying
        @Transactional
        @Query("update UserEntity user set user.firstName=:firstName where user.id=:id")
        void updateFirstName(String firstName, String id);

        @Modifying
        @Transactional
        @Query("update UserEntity user set user.kindergarten=:kindergarten where user.id=:id")
        void updateKindergarten(String kindergarten, String id);

        @Modifying
        @Transactional
        @Query("update UserEntity user set user.phone=:phone where user.id=:id")
        void updatePhone(String phone, String id);

        @Modifying
        @Transactional
        @Query("update UserEntity user set user.password=:newPswd where user.id=:id and user.password=:oldPswd")
        void updatePassword(String oldPswd, String newPswd, String id);


        boolean existsByEmail(String email);
        boolean existsByUsername(String username);

        UserEntity findByUsername(String username);

        UserEntity findUserEntityByToken(String token);
}
