/**
 * Created by xiaoxiao on 5/23/17.
 */
public class Roman2Integer_13 {
    public int romanToInt(String s) {
        int[] valArr = new int[s.length()];
        int result=0;
        for(int i = 0; i <s.length(); i++) {
            if (s.charAt(i) == 'I') {
                valArr[i] = 1;
            } else if (s.charAt(i) == 'V') {
                valArr[i] = 5;
            } else if (s.charAt(i) == 'X') {
                valArr[i] = 10;
            } else if (s.charAt(i) == 'L') {
                valArr[i] = 50;
            } else if (s.charAt(i) == 'C') {
                valArr[i] = 100;
            } else if (s.charAt(i) == 'D') {
                valArr[i] = 500;
            }else if (s.charAt(i) == 'M') {
                valArr[i] = 1000;
            }

        }
        for (int i = 0; i < s.length()-1; i++) {
            if (valArr[i] < valArr[i+1]) {
                result -= valArr[i];
            } else {
                result += valArr[i];
            }
        }
        return result+valArr[valArr.length-1];
    }
}
