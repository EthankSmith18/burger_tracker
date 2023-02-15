package com.ethan.burger_tracker.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ethan.burger_tracker.models.Burger;
import com.ethan.burger_tracker.services.BurgerService;

@Controller
public class MainController {
  @Autowired
  BurgerService burgerService;

  
  @RequestMapping("/")
  public String allBurgers(@ModelAttribute("burger") Burger burger, Model model) {
    List<Burger> burgers = burgerService.allBurgers();
    model.addAttribute("burgers", burgers);
    return "index.jsp";
  }

  @PostMapping("/burger")
    public String create(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, Model model) {
      if(result.hasErrors()){
        List<Burger> burgers = burgerService.allBurgers();
        model.addAttribute("burgers", burgers);
        return "index.jsp";

      }else{
            burgerService.createBurger(burger);
            return "redirect:/";
          }
        
  

}
}
