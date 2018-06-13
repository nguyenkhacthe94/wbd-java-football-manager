package com.codegym.football.repository;

import com.codegym.football.model.Player;
import com.codegym.football.model.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Long> {
}
