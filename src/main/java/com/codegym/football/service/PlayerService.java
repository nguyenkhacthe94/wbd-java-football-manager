package com.codegym.football.service;

import com.codegym.football.model.Player;
import com.codegym.football.model.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PlayerService {
    Page<Player> findAll(Pageable pageable);

    Page<Player> findAllByTeam(Team team, Pageable pageable);

    Player findById(Long id);

    Player save(Player player);

    void delete(Long id);
}
