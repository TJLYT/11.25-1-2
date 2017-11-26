import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * Created by qiuzhanghua on 2017/2/7.
 */
public class Sample2 {
  public static void main(String[] args) {


    String[] ss = {"Hello", "How", "are", "you"};
    List<Integer> list = Arrays.asList(1,1,2,3,5,8,13);

    // collect
    List<String> listOfString = Arrays.stream(ss).collect(toList());
    Integer[] ints = list.stream().toArray(Integer[] :: new);
    // create and collect
    List<Character> characters = Stream.of('a', 'b', 'c').collect(toList());

    Stream.of("中文","字符串").forEach(System.out :: println);
    Stream.of("中文","字符串").parallel().forEach(System.out :: println);

    Stream.of("中文","字符串").map(String::length).forEach(System.out::println);

    Stream.of("中文","字符串").filter(s -> s.length() == 3).forEach(System.out::println);
    Stream.of("中文","字符串").findFirst().orElse("Unknown");

    Stream.of("中文","字符串").peek(s -> System.out.print("log")).forEach(System.out::println);

    int sum = Stream.of(1,2,3,4).reduce((acc,x) -> acc + x).get();
    System.out.println(sum);
    // Stream.of(1,2,3,4).forEach(x -> {sum += x;});  // 非法，不能这样用


    // IntStream
    IntStream.of(5, 10);
    Stream.of("1", "3", "5").mapToInt(Integer::parseInt).forEach(System.out::println);
    IntStream.builder().add(1).add(2).add(3).build();
    IntStream.concat(IntStream.builder().add(1).build(), IntStream.builder().add(1).build());
    IntStream emptyStream = IntStream.empty();
    IntStream.generate(() -> 1).limit(30);
    IntStream.iterate(0, n -> n + 3).limit(3).boxed().collect(Collectors.toList());
    IntStream.range(30, 50);
    IntStream.rangeClosed(30, 50);


  }
}
