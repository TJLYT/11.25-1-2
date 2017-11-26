import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by qiuzhanghua on 2017/2/7.
 */
public class Sample1 {
  public static void main(String[] args) throws IOException {
    final String inputFileName = "sample1.txt";
    final String outputFileName = "sample1.5.txt";
    final int length = 5;

    List<String> words = Files.lines(Paths.get(inputFileName))
        .flatMap(Pattern.compile(" ")::splitAsStream)
        .filter(s -> s.length() == length)
        .map(String::toUpperCase)
        .distinct()
        .sorted()
        .collect(Collectors.toList());
    Files.write(Paths.get(outputFileName), words, StandardCharsets.UTF_8);

  }
}
