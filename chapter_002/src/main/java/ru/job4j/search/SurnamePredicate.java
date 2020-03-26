package ru.job4j.search;

import java.util.function.Predicate;

public class SurnamePredicate implements Predicate<Person> {
    private String key;

    public SurnamePredicate(String key) {
        this.key = key;
    }

    @Override
    public boolean test(Person person) {
        return  (person.getSurname().contains(key));
    }
}
