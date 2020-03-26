package ru.job4j.search;

import java.util.function.Predicate;

public class AddressPredicate implements Predicate<Person> {
    private String key;

    public AddressPredicate(String key) {
        this.key = key;
    }

    @Override
    public boolean test(Person person) {
        return  (person.getAddress().contains(key));
    }
}
