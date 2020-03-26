package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        Predicate<Person> namePredicate = new NamePredicate(key);
        Predicate<Person> surnamePredicate = new SurnamePredicate(key);
        Predicate<Person> phonePredicate = new PhonePredicate(key);
        Predicate<Person> addressPredicate = new AddressPredicate(key);
        for (Person person : persons) {
            if (namePredicate.or(surnamePredicate.or(phonePredicate.or(addressPredicate))).test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}