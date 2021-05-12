package com.gradi.app.badges.service;


import com.gradi.app.badges.model.BadgeEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BadgesServiceInterface {
    List<BadgeEntity> getAllBadges();
}
