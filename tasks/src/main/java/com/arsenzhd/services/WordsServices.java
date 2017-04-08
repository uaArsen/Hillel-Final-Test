package com.arsenzhd.services;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * Created by ArsZhd on 08.04.17.
 * Class with method that work with words.
 */
public class WordsServices {

    /**
     * @param path path to file with text.
     * @param rgex regular expression, filter word in text by this regex.
     * @return HashSet(distinct words) that not match regex. If one of arguments is null throw IllegalArgument
     * exception.
     * @throws IOException if it happens.
     */
    public static Set<String> findDistinctWordsInFile(String path, String rgex) throws IOException {
        if (path == null) {
            throw new IllegalArgumentException("Argument path is null.");
        }

        if (rgex == null) {
            throw new IllegalArgumentException("Argument rgex is null.");
        }
        return Files.readAllLines((new File(path)).toPath(), Charset.forName("UTF-8"))
                .stream()
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .filter(s -> !s.matches(rgex))
                .collect(Collectors.toCollection(HashSet::new));
    }
}
