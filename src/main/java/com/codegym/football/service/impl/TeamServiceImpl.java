package com.codegym.football.service.impl;

import com.codegym.football.model.Player;
import com.codegym.football.model.Team;
import com.codegym.football.repository.PlayerRepository;
import com.codegym.football.repository.TeamRepository;
import com.codegym.football.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class TeamServiceImpl implements TeamService {
    @Autowired
    TeamRepository teamRepository;

    @Autowired
    PlayerRepository playerRepository;

    @Override
    public Iterable<Team> findAll() {
        return teamRepository.findAll();
    }

    @Override
    public Team findById(Long id) {
        return teamRepository.findOne(id);
    }

    @Override
    public Team save(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Page<Player> findPlayers(Team team, Pageable pageable) {
        return playerRepository.findByTeam(team, pageable);
    }

    @Override
    public void delete(Long id) {
        teamRepository.delete(id);
    }
}
