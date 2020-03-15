package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.javawebinar.topjava.model.Meal;

import java.util.List;

public interface CrudMealRepository extends JpaRepository<Meal, Integer> {
    @Modifying
    @Query("SELECT m FROM Meal m WHERE m.user.id=:userId")
    List<Meal> getAll(@Param("userId") int userId);
}
