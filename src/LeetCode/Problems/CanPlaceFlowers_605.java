package LeetCode.Problems;

public class CanPlaceFlowers_605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 1){
            return flowerbed[0] == 0 && n <= 1 || flowerbed[0] == 1 && n == 0;
        }
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (i == 0 ) {
                if (flowerbed[0] == 0 && flowerbed[1] == 0) {
                    flowerbed[0] = 1;
                    count++;
                }
            } else if (i == flowerbed.length-1) {
                if (flowerbed[flowerbed.length-1] == 0 && flowerbed[flowerbed.length-2] == 0) {
                    flowerbed[flowerbed.length-1] = 1;
                    count++;
                }
            } else if (flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                count++;
            }
            if (count >= n) return true;
        }
        return false;
    }
}
