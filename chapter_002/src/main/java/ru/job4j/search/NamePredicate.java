package ru.job4j.search;

import java.util.function.Predicate;

public class NamePredicate implements Predicate<Person> {
    private String key;

    public NamePredicate(String key) {
        this.key = key;
    }

    @Override
    public boolean test(Person person) {
        return  (person.getName().contains(key));
    }
}
