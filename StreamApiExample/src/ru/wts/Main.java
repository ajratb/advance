package ru.wts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author BikchentaevAA
 */
public class Main {

    public static void main(String[] args) {
        List<String[]> stringArrays = new ArrayList<>();
        stringArrays.add(new String[]{"a","b"});
        stringArrays.add(new String[]{"1","2"});
        stringArrays.stream().flatMap(ar -> Arrays.asList(ar).stream())
                .forEach(System.out::println);
//        stringArrays.stream().flatMap(ar -> Arrays.stream(ar))
//                .forEach(System.out::println);
        
        
        String[][] data = {{"a", "b", "c"},{"d","e"},{"f"}};
        Stream<String[]> dataStream = Arrays.stream(data);
        Stream<String> strings = dataStream.flatMap(sArr-> Arrays.stream(sArr));
//        strings.forEach(System.out::println);
        
        String reduced = strings.reduce((a,b)->a + b).orElse("не получилось");
        System.out.println(reduced);
        
    }
    
}
