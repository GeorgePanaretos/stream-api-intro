package com.stream.intro.stream.api;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.*;

public class CreationStream {

    public Stream<String> streamOf (List < String > list) {
        return list == null || list.isEmpty() ? Stream.empty() : list.stream();
    }

    public static void main (String [] args) throws IOException {
        System.out.println("------ Empty Stream ------");
        Stream<String> streamEmpty = Stream.empty();
        streamEmpty.forEach(System.out::println);

        System.out.println("------ Stream of Collection ------");
        Collection<String> collection = Arrays.asList("a", "b", "c");
        Stream<String> streamOfCollection = collection.stream();
        streamOfCollection.forEach(System.out::println);
        System.out.println();

        System.out.println("------ Stream of Array ------");
        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> streamOfArrayFull = Arrays.stream(arr);
        streamOfArrayFull.forEach(System.out::println);
        System.out.println();
        System.out.println("Inclusive from 1 to 3 index");
        Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
        streamOfArrayPart.forEach(System.out::println);
        System.out.println();

        System.out.println("------ Stream of Map for Key-Value Pair ------");
        Stream<Map.Entry<String, Integer>> mapStream = Map.of("Alice", 25, "Bob", 30, "Charlie", 35).entrySet().stream();
        mapStream.forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));
        System.out.println();

        System.out.println("------ Stream of Builder ------");
        Stream<String> streamBuilder =
                Stream.<String>builder().add("a").add("b").add("c").build();
        streamBuilder.forEach(System.out::println);
        System.out.println();

        System.out.println("------ Mixed Stream ------");
        Stream<Object> mixedStream = Stream.of("Hello", 42, 3.14, "World", 100);
        mixedStream.forEach(System.out::println);
        System.out.println();

        System.out.println("------ Stream Iterated ------");
        Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);
        streamIterated.forEach(System.out::println);
        System.out.println();

        System.out.println("------ Stream of Primitives ------");
        IntStream intStream = IntStream.range(1, 3);
        LongStream longStream = LongStream.rangeClosed(1, 3);
        intStream.forEach(System.out::println);
        System.out.println();

        System.out.println("------ Stream of Generated ------");
        Stream<String> streamGenerated =
                Stream.generate(() -> "element").limit(10);
        streamGenerated.forEach(System.out::println);
        System.out.println();

        System.out.println("------ Stream of File ------");
        Path path = Paths.get("C:\\Users\\georg\\Downloads\\stream.api\\src\\main\\java\\com\\stream\\intro\\stream\\api\\file.txt");
        Stream<String> streamOfStrings = Files.lines(path);
        Stream<String> streamWithCharset =
                Files.lines(path, Charset.forName("UTF-8"));
        streamWithCharset.forEach(System.out::println);
        System.out.println();

    }

}
