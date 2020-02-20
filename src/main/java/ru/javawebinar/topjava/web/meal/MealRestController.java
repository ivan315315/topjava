package ru.javawebinar.topjava.web.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.web.SecurityUtil;

import java.util.List;

import static ru.javawebinar.topjava.util.ValidationUtil.*;

@Controller
public class MealRestController {
    @Autowired
    private MealService service;

    public Meal create(Meal meal) {
        checkNew(meal);
        return service.create(meal);
    }

    public void delete(int id) {
        checkEntityByUser(id, SecurityUtil.authUserId());
        service.delete(id);
    }

    public void get(int id) {
        checkEntityByUser(id, SecurityUtil.authUserId());
        service.get(id);
    }

    public List<Meal> getAll() {
        return (List<Meal>) service.getAll();
    }

    public List<Meal> getAllForUser() {
        return (List<Meal>) service.getAllForUser(SecurityUtil.authUserId());
    }

    public void update(Meal meal, int id) {
        checkEntityByUser(meal.getUserId(), SecurityUtil.authUserId());
        assureIdConsistent(meal, id);
        service.update(meal);
    }
    ///если еда не принадлежит авторизированному пользователю или отсутствует, в MealService бросать NotFoundException.
}