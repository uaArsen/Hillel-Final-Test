package com.arsenzhd;

import com.arsenzhd.services.CollectionsServices;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ArsZhd on 08.04.17.
 * Test for CollectionsServices.
 */
public class CollectionsTests {
    private static List<Integer> list;
    private static Set<Integer> set;

    @BeforeClass
    public static void init() {
        list = new ArrayList<>();
        set = new HashSet<>();
        list.add(1);
        list.add(1);
        set.add(1);
    }

    @Test
    public void testFromArrayToCollection() {
        Assert.assertEquals(set, CollectionsServices.fromArrayToCollection(new Integer[]{1, 1}, new HashSet<>()));
        Assert.assertEquals(list, CollectionsServices.fromArrayToCollection(new Integer[]{1, 1}, new ArrayList<>()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFromNullToCollection() {
        CollectionsServices.fromArrayToCollection(null, new HashSet<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFromArrayToNull() {
        CollectionsServices.fromArrayToCollection(new Integer[]{1}, null);
    }

}
