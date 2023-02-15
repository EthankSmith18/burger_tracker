package com.ethan.burger_tracker.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ethan.burger_tracker.models.Burger;

@Repository
public interface BurgerRepository extends CrudRepository<Burger, Long>{
    // this method retrieves all the books from the database
    List<Burger> findAll();
}
  

