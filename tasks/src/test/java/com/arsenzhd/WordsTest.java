package com.arsenzhd;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static com.arsenzhd.services.WordsServices.findDistinctWordsInFile;

/**
 * Created by ArsZhd on 08.04.17.
 */
public class WordsTest {
    private static Set<String> words;
    @BeforeClass
    public static void init() {
        words = new HashSet<>();
        words.add("Word");
        words.add("word");
        words.add("No");
        words.add("test");
    }

    @Test
    public void testFindDistinctWordsInFile() throws IOException {
        Assert.assertEquals(words,
                findDistinctWordsInFile(System.getProperty("user.dir")
                        +
                        "/src/main/resources/test.txt", ".*[.:,/;].*"));
    }
}
