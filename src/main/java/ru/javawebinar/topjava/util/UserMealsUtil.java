package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExcess;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserMealsUtil {
    public static final int EXCESS = 2000;
    public static void main(String[] args) {
        List<UserMeal> meals = Arrays.asList(
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 410)
        );

        List<UserMealWithExcess> mealsTo = filteredByCycles(meals, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000);
        mealsTo.forEach(System.out::println);

//        System.out.println(filteredByStreams(meals, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000));
    }

    public static List<UserMealWithExcess> filteredByCycles(List<UserMeal> meals, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        // TODO return filtered list with excess. Implement by cycles
        List<UserMealWithExcess> listMeal = new ArrayList();
        Map<Integer, Integer> map = new HashMap();
        for(UserMeal meal: meals){
            int days = meal.getDateTime().toLocalDate().getDayOfYear();
            if (!map.containsKey(days)){
                map.put(days, meal.getCalories());
            } else {
                map.put(days, map.get(days) + meal.getCalories());
            }
        }
        for (UserMeal meal: meals){
            int excesssum = map.get(meal.getDateTime().toLocalDate().getDayOfYear());
            if (meal.getDateTime().toLocalTime().isAfter(startTime) && meal.getDateTime().toLocalTime().isBefore(endTime)){
                listMeal.add(new UserMealWithExcess(meal, excesssum >= EXCESS));
            }
        }
        return listMeal;
    }

    public static List<UserMealWithExcess> filteredByStreams(List<UserMeal> meals, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        // TODO Implement by streams

        Map<Integer, Integer> map = meals.stream()
                .collect(Collectors.groupingBy(UserMeal -> UserMeal.getDateTime().toLocalDate().getDayOfYear(), Collectors.summingInt(UserMeal::getCalories)));
        /*Map<String, Double> map5 = workers.stream()
       .collect(Collectors.groupingBy(Worker::getPosition,
              Collectors.averagingInt(Worker::getSalary)));*/



        Set<Integer> set = meals.stream().map(UserMeal -> UserMeal.getDateTime().toLocalDate().getDayOfYear())
                .collect(Collectors.toSet());

        

        /*set.stream().forEach(day ->
                meals.stream().filter(userMeal -> {
                    return userMeal.getDateTime().toLocalDate().getDayOfYear() == day.intValue();})
                .map(UserMeal -> UserMeal.getCalories())
                .reduce(0, (x, y) -> x + y)
        );*/

        /*set.stream().map(day ->
                meals.stream().filter(userMeal -> {
                    return userMeal.getDateTime().toLocalDate().getDayOfYear() == day.intValue();})
                        .map(UserMeal -> UserMeal.getCalories())
                        .reduce(0, (x, y) -> x + y)
        ).collect(Collectors.toMap(day, ));*/


        //Map<Integer, Integer> map = meals.stream().;

        return null;
    }
}
