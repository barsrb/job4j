package ru.job4j.stream;

import org.junit.Test;
import ru.job4j.pojo.Address;
import ru.job4j.pojo.Profile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void collectAddresses() {
        List<Profile> profiles = new ArrayList<>();
        Address address1 = new Address("Moscow", "Moroseyka", 12, 12);
        Address address2 = new Address("Moscow", "Petrovka", 38, 0);
        Address address3 = new Address("Omsk", "Omskaya", 1, 1);
        profiles.add(new Profile(address1));
        profiles.add(new Profile(address2));
        profiles.add(new Profile(address3));

        List<Address> collected = Profiles.collect(profiles);
        List<Address> expected = Arrays.asList(address1, address2, address3);
        assertThat(collected, is(expected));
    }

    @Test
    public void collectUniqueAndSortedAddresses() {
        Address address1 = new Address("Moscow", "Moroseyka", 12, 12);
        Address address2 = new Address("Moscow", "Petrovka", 38, 0);
        Address address3 = new Address("Minsk", "Petrovka", 38, 0);
        Address address4 = new Address("Omsk", "Omskaya", 1, 1);
        Address address5 = new Address("Omsk", "Omskaya", 1, 1);
        Address address6 = new Address("Manchester", "Unknown", 1, 1);
        List<Profile> profiles = List.of(
                new Profile(address1),
                new Profile(address2),
                new Profile(address3),
                new Profile(address4),
                new Profile(address5),
                new Profile(address6)
        );

        List<Address> collected = Profiles.collectUniqueAndSorted(profiles);
        assertEquals(collected.size(), 5);
        assertThat(collected.get(0), is(address6));
        assertThat(collected.get(1), is(address3));
        assertThat(collected.get(4), is(address4));
    }

}