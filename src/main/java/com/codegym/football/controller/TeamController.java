package com.codegym.football.controller;

import com.codegym.football.model.Player;
import com.codegym.football.model.Team;
import com.codegym.football.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TeamController {
    @Autowired
    TeamService teamService;

    @GetMapping("/team-list")
    public ModelAndView showTeamList() {
        Iterable<Team> teams = teamService.findAll();
        ModelAndView modelAndView = new ModelAndView("/team/list");
        modelAndView.addObject("teams", teams);
        return modelAndView;
    }

    @GetMapping("/team/{id}")
    public ModelAndView showTeamPlayer(@PathVariable("id") Long id, Pageable pageable) {
        Team team = teamService.findById(id);
        Page<Player> players = teamService.findPlayers(team, pageable);
        ModelAndView modelAndView =  new ModelAndView("/team/view");
        modelAndView.addObject("team", team);
        modelAndView.addObject("players", players);
        return modelAndView;
    }

    @GetMapping("/create-team")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/team/create");
        modelAndView.addObject("team", new Team());
        return modelAndView;
    }

    @PostMapping("/create-team")
    public ModelAndView saveTeam(@ModelAttribute("team") Team team) {
        teamService.save(team);
        ModelAndView modelAndView = new ModelAndView("/team/create");
        modelAndView.addObject("team", new Team());
        modelAndView.addObject("message", "New team is successfully created");
        return modelAndView;
    }

    @GetMapping("/edit-team/{id}")
    public ModelAndView showEditForm(@PathVariable("id") Long id) {
        Team team = teamService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/team/edit");
        modelAndView.addObject("team", team);
        return modelAndView;
    }

    @PostMapping("/edit-team/{id}")
    public ModelAndView updateTeam(@ModelAttribute("team") Team team) {
        teamService.save(team);
        ModelAndView modelAndView = new ModelAndView("/team/edit");
        modelAndView.addObject("team", team);
        modelAndView.addObject("message", "Team is successfully updated");
        return modelAndView;
    }

    @GetMapping("/delete-team/{id}")
    public ModelAndView showDeleteForm(@PathVariable("id") Long id) {
        Team team = teamService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/team/delete");
        modelAndView.addObject("team", team);
        return modelAndView;
    }

    @PostMapping("/delete-team/{id}")
    public String deleteTeam(@ModelAttribute("team")Team team) {
        teamService.delete(team.getId());
        return "redirect:/teams";
    }
}
