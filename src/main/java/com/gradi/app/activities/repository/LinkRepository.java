package com.gradi.app.activities.repository;

import com.gradi.app.activities.model.linkRelated.LinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkRepository extends JpaRepository<LinkEntity, String> {
}
