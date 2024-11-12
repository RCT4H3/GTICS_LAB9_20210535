package com.example.gtics_lab9_20210535.Controller;

import com.example.gtics_lab9_20210535.Daos.MealDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/feature")
public class MealController {

    final MealDao mealDao;

    public MealController(MealDao mealDao) {
        this.mealDao = mealDao;
    }

    @GetMapping({"/list","","/"})
    public String listMeals(Model model) {

        model.addAttribute("listaMeals", mealDao.listar());
        return "listaMeals";
    }
}
