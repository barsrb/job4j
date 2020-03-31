package ru.job4j.search;

import java.util.ArrayList;

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
        var result = new ArrayList<Person>();
        var namePredicate = new NamePredicate(key);
        var surnamePredicate = new SurnamePredicate(key);
        var phonePredicate = new PhonePredicate(key);
        var addressPredicate = new AddressPredicate(key);
        for (var person : persons) {
            if (namePredicate.or(surnamePredicate.or(phonePredicate.or(addressPredicate))).test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}