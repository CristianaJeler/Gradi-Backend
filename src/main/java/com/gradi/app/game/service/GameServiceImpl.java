package com.gradi.app.game.service;


import com.gradi.app.game.model.GameEntity;
import com.gradi.app.game.repository.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class GameServiceImpl implements GameServiceInterface {
    @Autowired
    GameRepository gameRepository;


    @Override
    public List<GameEntity> getAllGames() {
        return gameRepository.findAll();
    }
}
