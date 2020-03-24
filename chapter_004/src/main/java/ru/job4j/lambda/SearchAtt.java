package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {

    public static List<Attachment> filterSize(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getSize() > 100) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getName().contains("test4")) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> filter(List<Attachment> list, Predicate filter) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (filter.test(att)) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static class SizeFilter implements Predicate<Attachment> {
        private Integer size;
        public SizeFilter(Integer size) {
            this.size = size;
        }

        @Override
        public boolean test(Attachment input) {
            return input.getSize() > size;
        }
    }

    public static class NameFilter implements Predicate<Attachment> {
        private String string;

        public NameFilter(String string) {
            this.string = string;
        }

        @Override
        public boolean test(Attachment input) {
            return input.getName().contains(string);
        }
    }
}