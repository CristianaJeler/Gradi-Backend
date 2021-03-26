package com.gradi.app.group.repository;

import com.gradi.app.group.model.UserGroupEntity;
import com.gradi.app.group.model.UserGroupKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface UserGroupRepository extends JpaRepository<UserGroupEntity, UserGroupKey> {

    @Transactional
    @Query(value="select * from users_groups ug where ug.user_id=:userID", nativeQuery = true)
    List<UserGroupEntity> getUsersGroups(String userID);
}
