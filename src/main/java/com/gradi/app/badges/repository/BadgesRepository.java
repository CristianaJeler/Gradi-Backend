package com.gradi.app.badges.repository;

import com.gradi.app.badges.model.BadgeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BadgesRepository extends JpaRepository<BadgeEntity, Integer> {

}
