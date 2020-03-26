package ru.job4j.search;

import java.util.function.Predicate;

public class PhonePredicate implements Predicate<Person> {
    private String key;

    public PhonePredicate(String key) {
        this.key = key;
    }

    @Override
    public boolean test(Person person) {
        return  (person.getPhone().contains(key));
    }
}
