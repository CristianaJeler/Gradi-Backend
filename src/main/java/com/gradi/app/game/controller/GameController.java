package com.gradi.app.game.controller;


import com.gradi.app.game.model.GameEntity;
import com.gradi.app.game.service.GameServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/gradi/games")
public class GameController {
    @Autowired
    GameServiceInterface gameService;

    @GetMapping(value = "")
    public ResponseEntity<List<GameEntity>> getAllGames(){
        return ResponseEntity.ok(gameService.getAllGames());
    }
}
