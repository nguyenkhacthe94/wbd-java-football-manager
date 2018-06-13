package com.codegym.football.service;

import com.codegym.football.model.Player;
import com.codegym.football.model.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TeamService {
    Iterable<Team> findAll();

    Team findById(Long id);

    Team save(Team team);

    void delete(Long id);

    Page<Player> findPlayers(Team team, Pageable pageable);
}
