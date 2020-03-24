package ru.job4j.search;

import java.util.function.Predicate;

public class CombinePredicate implements Predicate<Person> {

    private String key;

    public CombinePredicate(String key) {
        this.key = key;
    }

    @Override
    public boolean test(Person person) {
        return  (person.getName().contains(key)
                || person.getSurname().contains(key)
                || person.getAddress().contains(key)
                || person.getPhone().contains(key));
    }
}
