package com.arsenzhd.services;

import java.util.Arrays;
import java.util.Collection;


/**
 * Created by ArsZhd on 08.04.17.
 * Class with methods for working with collections.
 */
public class CollectionsServices {

    /**
     *
     * @param array input array.
     * @param collection collection where to add objects.
     * @param <T> generic type.
     * @return Collection with objects from input array. Throw IllegalArgumentException if one of the argument was null.
     */
    public static <T> Collection<T> fromArrayToCollection(T[] array, Collection<T> collection) {
        if (array == null) {
            throw new IllegalArgumentException("Argument array is null.");
        }

        if (collection == null) {
            throw new IllegalArgumentException("Argument collection is null.");
        }
        collection.addAll(Arrays.asList(array));
        return collection;
    }
}
