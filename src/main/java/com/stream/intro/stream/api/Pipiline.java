package com.stream.intro.stream.api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Pipiline {

    public static  void main(String[] args) {

        System.out.println("--- Skipping First Element ---");
        Stream<String> onceModifiedStream =
                Stream.of("abcd", "bbcd", "cbcd").skip(1);
        onceModifiedStream.forEach(System.out::println);

        List<String> words = Arrays.asList("Hello", "World", "Stream", "API");

        System.out.println("\n--- Skipping First and Mapping to 3 Characters ---");
        Stream<String> twiceModifiedStream =words.stream()
                .skip(1)
                .map(element -> {
                    System.out.println("Mapping: " + element);
                    return element.substring(0, 3);
                });

        twiceModifiedStream.forEach(System.out::println);

        System.out.println("\n--- Skipping First and Sorting ---");
        List<String> list = Arrays.asList("abc1", "abc2", "abc3");
        long size = list.stream().skip(1)
                .map(element -> element.substring(0, 3))
                .sorted()
                .count();
        list.stream().skip(1).forEach(System.out::println);

        System.out.println(size);

        System.out.println("\n--- Skipping First Element and Printing List ---");
        list.stream()
                .skip(1)
                .forEach(System.out::println);
    }
}
