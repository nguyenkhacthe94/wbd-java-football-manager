package com.codegym.football.service.impl;

import com.codegym.football.model.Player;
import com.codegym.football.model.Team;
import com.codegym.football.repository.PlayerRepository;
import com.codegym.football.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class PlayerServiceImpl implements PlayerService {
    @Autowired
    PlayerRepository playerRepository;

    @Override
    public Page<Player> findAll(Pageable pageable) {
        return playerRepository.findAll(pageable);
    }

    @Override
    public Player findById(Long id) {
        return playerRepository.findOne(id);
    }

    @Override
    public Player save(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Page<Player> findAllByTeam(Team team, Pageable pageable) {
        return playerRepository.findByTeam(team, pageable);
    }

    @Override
    public void delete(Long id) {
        playerRepository.delete(id);
    }
}
