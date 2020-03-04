package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }

    @Test
    public void  whenFindTwo() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Ivan", "Petrov", "88005553535", "Moskow"));
        phones.add(new Person("Petr", "Ivanov", "88001234567", "SPb"));
        phones.add(new Person("Sidor", "Sidorov", "000999888777", "Ontario"));

        ArrayList<Person> persons = phones.find("Petr");

        assertThat(persons.size(), is(2));
    }
}