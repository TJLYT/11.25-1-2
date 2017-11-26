import java.util.stream.Stream;

/**
 * Created by qiuzhanghua on 2017/2/7.
 */
public class Fib {
  public static void main(String[] args) {
    Stream<Long> longStream = Stream.generate(new FibonacciSupplier());
    longStream.limit(10).forEach(System.out::println);
  }
}
