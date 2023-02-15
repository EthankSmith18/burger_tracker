package com.ethan.burger_tracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ethan.burger_tracker.models.Burger;
import com.ethan.burger_tracker.repositories.BurgerRepository;

@Service
public class BurgerService {
    @Autowired
    BurgerRepository burgerRepository;

    // returns all the burgers
    public List<Burger> allBurgers() {
        return burgerRepository.findAll();
    }

    // creates a burger
    public Burger createBurger(Burger b) {
        return burgerRepository.save(b);
    }

    // edit a burger
    public void updateBurger(Burger b) {
        burgerRepository.save(b);
    }

    // retrieves a book
    public Burger findBurger(Long id) {
        Optional<Burger> optionalBurger = burgerRepository.findById(id);
        if (optionalBurger.isPresent()) {
            return optionalBurger.get();
        } else {
            return null;
        }
    }


    public void deleteBurger(Long id) {
    }
}
