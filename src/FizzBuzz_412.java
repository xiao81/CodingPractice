import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiaoxiao on 4/26/17.
 */
public class FizzBuzz_412 {
    public List<String> fizzBuzz(int n) {
        List<String> resultList = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0 ) {
                resultList.add("FizzBuzz");
            } else if (i % 3 == 0) {
                resultList.add("Fizz");
            } else if ( i % 5 == 0) {
                resultList.add("Buzz");
            } else {
                resultList.add(String.valueOf(i));
            }
        }
        return resultList;
    }
}
