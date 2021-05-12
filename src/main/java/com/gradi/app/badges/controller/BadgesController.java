package com.gradi.app.badges.controller;


import com.gradi.app.badges.model.BadgeEntity;
import com.gradi.app.badges.service.BadgesServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/gradi/badges")
public class BadgesController {
    @Autowired
    BadgesServiceInterface badgesService;

    @GetMapping(value="")
    public ResponseEntity<List<BadgeEntity>> getAllBadges(){
        return ResponseEntity.ok(badgesService.getAllBadges());
    }
}
