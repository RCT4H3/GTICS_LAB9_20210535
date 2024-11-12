package com.example.gtics_lab9_20210535.Controller;

import com.example.gtics_lab9_20210535.Daos.MealDao;
import com.example.gtics_lab9_20210535.Entity.Meal1;
import com.example.gtics_lab9_20210535.Entity.Meal2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @PostMapping("/buscar")
    public String buscarMeal(Model model, @RequestParam("buscar") String buscar) {
        List<Meal2> lista = mealDao.listar2(buscar);
        System.out.println(buscar);
        model.addAttribute("buscado", buscar);
        model.addAttribute("listaMeals", lista);

        return "listaMeals2";
    }

    @PostMapping("/detail")
    public String detailMeal(Model model, @RequestParam("id") String id, @RequestParam("buscar") String buscar) {
        List<Meal2> lista = mealDao.listar2(buscar);
        Meal2 encontrado = null;
        System.out.println(buscar);
        for (Meal2 meal : lista) {
            if (meal.getIdMeal().equals(id)) {
                encontrado = meal;
                break;
            }
        }


        model.addAttribute("meal", encontrado);
        return "detailMeal";
    }
}
