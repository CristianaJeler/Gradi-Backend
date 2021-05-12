package com.gradi.app.activities.repository;

import com.gradi.app.activities.model.mediaRelated.MediaContentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MediaRepository extends JpaRepository<MediaContentEntity, String> {
}
