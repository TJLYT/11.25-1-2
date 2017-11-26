import java.util.function.Supplier;

/**
 * Created by qiuzhanghua on 2017/2/7.
 */
public class FibonacciSupplier implements Supplier<Long> {
  private long previous = 1;
  private long current = 2;

  private long after=previous+current +1;
  @Override
  public Long get() {
    long p = previous;
    long next = current + previous+after;
    previous = current;
    
    current = after;
    
       after = next;
    return p;
  }
}
