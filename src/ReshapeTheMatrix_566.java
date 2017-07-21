import java.util.Arrays;

public class ReshapeTheMatrix_566 {
    public static void main(String[] args) {
        ReshapeTheMatrix_566 reshapeTheMatrix_566 = new ReshapeTheMatrix_566();
        System.out.println(Arrays.deepToString(reshapeTheMatrix_566.matrixReshape(new int[][]{{1,2},{3,4}}, 1,4)));
        System.out.println(Arrays.deepToString(reshapeTheMatrix_566.matrixReshape(new int[][]{{1,2},{3,4}}, 2,4)));
        System.out.println(Arrays.deepToString(reshapeTheMatrix_566.matrixReshape(new int[][]{{1}},1,1)));
    }
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (r * c != nums.length*nums[0].length) {
            return nums;
        }
        int[][] reshapedMatrix = new int[r][c];
        int row = 0, col = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                reshapedMatrix[row][col] = nums[i][j];
                if (col != c - 1) {
                    col++;
                } else if (row != r - 1) {
                    row++;
                    col = 0;
                }
            }
        }

        return reshapedMatrix;
    }
}
