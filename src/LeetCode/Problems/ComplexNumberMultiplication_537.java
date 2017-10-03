package LeetCode.Problems;

/**
 * Created by xiaoxiao on 4/26/17.
 */
public class ComplexNumberMultiplication_537 {
    public String complexNumberMultiply(String a, String b) {
        int r1 = Integer.valueOf(a.split("\\+")[0]);
        int r2 = Integer.valueOf(b.split("\\+")[0]);
        int c1 = Integer.valueOf(a.split("\\+")[1].split("i")[0]);
        int c2 = Integer.valueOf(b.split("\\+")[1].split("i")[0]);
        int resultR = r1 * r2 - c1 * c2;
        int resultC = r1 * c2 + c1 * r2;

        return String.valueOf(resultR) + "+" + String.valueOf(resultC) +"i";
     }
}
