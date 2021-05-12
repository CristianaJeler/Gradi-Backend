package com.gradi.app.badges.service;

import com.gradi.app.badges.model.BadgeEntity;
import com.gradi.app.badges.repository.BadgesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BadgesServiceImpl implements BadgesServiceInterface{
    @Autowired
    BadgesRepository badgesRepository;


    @Override
    public List<BadgeEntity> getAllBadges() {
        return badgesRepository.findAll();
    }
}
