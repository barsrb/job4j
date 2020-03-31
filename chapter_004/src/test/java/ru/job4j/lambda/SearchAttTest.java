package ru.job4j.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SearchAttTest {

    private Attachment test1 = new Attachment("test1", 10);
    private Attachment test2 = new Attachment("test2", 1000);
    private Attachment test3 = new Attachment("test3", 200);
    private Attachment test41 = new Attachment("test41", 20);
    private Attachment test42 = new Attachment("test42", 40);
    private List<Attachment> list = List.of(test1, test2, test3, test41, test42);

    @Test
    public void compareFilteredAttachmentsWithNameTest4() {
        List<Attachment> byName = SearchAtt.filterName(list);
        List<Attachment> byNameWithPredicate = SearchAtt.filter(list, new SearchAtt.NameFilter("test4"));
        assertEquals(byName, byNameWithPredicate);
    }

    @Test
    public void compareFilteredAttachmentsWithSizeMore100() {
        List<Attachment> bySize = SearchAtt.filterSize(list);
        List<Attachment> bySizeWithPredicate = SearchAtt.filter(list, new SearchAtt.SizeFilter(100));
        assertEquals(bySize, bySizeWithPredicate);
    }


}