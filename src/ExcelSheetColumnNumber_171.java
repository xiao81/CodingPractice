import com.sun.javafx.geom.Edge;

/**
 * Created by xiaoxiao on 5/22/17.
 */
public class ExcelSheetColumnNumber_171 {
    public static void main(String[] args) {
        ExcelSheetColumnNumber_171 e = new ExcelSheetColumnNumber_171();
        System.out.println(e.titleToNumber("AAA"));
    }
    public int titleToNumber(String s) {
        int result = 0;
        for (int i = s.length()-1; i >=0 ; i--) {
            result += (s.charAt(i) - 64) *Math.pow(26,(s.length()-1-i));
        }
        return result;
    }

}
