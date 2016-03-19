package lambdasinaction.chapter5_STREAMS2;

import lambdasinaction.chapter4_STREAMS.*;

import java.util.*;
import static java.util.stream.Collectors.toList;
import static lambdasinaction.chapter4_STREAMS.Dish.menu;

public class Mapping{

    public static void main(String...args){

        // map function can be applied multiple times
        List<Integer> dishNames = menu.stream()
                                     .map(Dish::getName)
                                     .map(String::length)
                                     .collect(toList());
        System.out.println(dishNames);

        // map
        List<String> words = Arrays.asList("Hello", "World");
        List<Integer> wordLengths = words.stream()
                                         .map(String::length)
                                         .collect(toList());
        System.out.println(wordLengths);

        // flatMap
        words.stream()
                .map(w -> w.split(""))
                 .flatMap(Arrays::stream)
                 .distinct()
                 .forEach(System.out::println);

        // flatMap
        List<Integer> numbers1 = Arrays.asList(1,2,3,4,5);
        List<Integer> numbers2 = Arrays.asList(6,7,8);
        List<int[]> pairs =
                        numbers1.stream()
                                .flatMap((Integer i) -> numbers2.stream()
                                                       .map((Integer j) -> new int[]{i, j})
                                 )
                                .filter(pair -> (pair[0] + pair[1]) % 3 == 0)
                                .collect(toList());
        pairs.forEach(pair -> System.out.println("(" + pair[0] + ", " + pair[1] + ")"));
    }
}
