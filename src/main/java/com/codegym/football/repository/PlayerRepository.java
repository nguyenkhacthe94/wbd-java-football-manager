package com.codegym.football.repository;

import com.codegym.football.model.Player;
import com.codegym.football.model.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface PlayerRepository extends PagingAndSortingRepository<Player, Long> {
    @Query("select new Player(p.id, p.name, p.age, p.height, p.nationality, p.position, p.team) from Player p where p.team = :team")
    Page<Player> findByTeam(@Param("team") Team team, Pageable pageable);

//    @Query("select new Player(p.id, p.name, p.age, p.height, p.nationality, p.position, p.team) from Player p")
//    Page<Player> findAllSummary(Pageable pageable);
}
