package de.flozo.GymApp.controllers;

import de.flozo.GymApp.services.WorkoutUnitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private final WorkoutUnitService workoutUnitService;

    public IndexController(WorkoutUnitService workoutUnitService) {
        this.workoutUnitService = workoutUnitService;
    }

    @RequestMapping({"", "/", "index", "index.html"})
    public String getIndexPage(Model model) {
        model.addAttribute("workout_units", workoutUnitService.findAllByOrderByDateDesc());
        return "index";
    }

}
