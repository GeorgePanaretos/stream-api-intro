package com.stream.intro.stream.api;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reference {

    public static void main (String [] args){

        List<String> elements =
                Stream.of("a", "b", "c").filter(element -> element.contains("b"))
                        .collect(Collectors.toList());
        Optional<String> anyElement = elements.stream().findAny();
        System.out.println(anyElement);
        Optional<String> firstElement = elements.stream().findFirst();
        System.out.println(firstElement);
    }
}
