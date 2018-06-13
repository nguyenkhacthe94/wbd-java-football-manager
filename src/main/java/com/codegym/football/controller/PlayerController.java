package com.codegym.football.controller;

import com.codegym.football.model.Player;
import com.codegym.football.model.Team;
import com.codegym.football.service.PlayerService;
import com.codegym.football.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PlayerController {
    @Autowired
    PlayerService playerService;

    @Autowired
    TeamService teamService;

    @ModelAttribute("teams")
    public Iterable<Team> teams() {
        return teamService.findAll();
    }

    @GetMapping("/player/{id}")
    public ModelAndView showPlayer(@PathVariable("id") Long id) {
        Player player = playerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/player/view");
        modelAndView.addObject("player", player);
        return modelAndView;
    }

    @GetMapping("/create-player")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/player/create");
        modelAndView.addObject("player", new Player());
        return modelAndView;
    }

    @PostMapping("/create-player")
    public ModelAndView savePlayer(@ModelAttribute("player") Player player) {
        playerService.save(player);
        ModelAndView modelAndView = new ModelAndView("/player/create");
        modelAndView.addObject("player", new Player());
        modelAndView.addObject("message", "New player is successfully created");
        return modelAndView;
    }

    @GetMapping("/edit-player/{id}")
    public ModelAndView showEditForm(@PathVariable("id") Long id) {
        Player player = playerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/player/edit");
        modelAndView.addObject("player", player);
        return modelAndView;
    }

    @PostMapping("/edit-player/{id}")
    public ModelAndView updatePlayer(@ModelAttribute("player") Player player) {
        playerService.save(player);
        ModelAndView modelAndView = new ModelAndView("/player/edit");
        modelAndView.addObject("player", player);
        modelAndView.addObject("message", "Player infomation is successfully updated");
        return modelAndView;
    }

    @GetMapping("/delete-player/{id}")
    public ModelAndView showDeleteForm(@PathVariable("id") Long id) {
        Player player = playerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/player/delete");
        modelAndView.addObject("player", player);
        return modelAndView;
    }

    @PostMapping("/delete-player/{id}")
    public String deletePlayer(@ModelAttribute("player") Player player) {
        playerService.delete(player.getId());
        return "redirect:/team-list";
    }
}
