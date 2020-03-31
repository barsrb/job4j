package ru.job4j.stream;

import ru.job4j.pojo.Address;
import ru.job4j.pojo.Profile;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .collect(Collectors.toList());
    }

    public static List<Address> collectUniqueAndSorted(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .sorted(new AddressCityComparator())
                .distinct()
                .collect(Collectors.toList());
    }
}
