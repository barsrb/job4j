package ru.job4j.stream;

import ru.job4j.pojo.Address;

import java.util.Comparator;

public class AddressCityComparator implements Comparator<Address> {
    @Override
    public int compare(Address address1, Address address2) {
        return address1.getCity().compareTo(address2.getCity());
    }
}
