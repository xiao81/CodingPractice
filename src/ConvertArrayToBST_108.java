/**
 * Created by xiaoxiao on 5/28/17.
 */
public class ConvertArrayToBST_108 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private int[] inputArr;
    public TreeNode sortedArrayToBST(int[] nums) {
        inputArr = nums;
        return sortedArrayToBSTHelper(0, nums.length-1);
    }

    public TreeNode sortedArrayToBSTHelper(int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start+end)/2;
        TreeNode root = new TreeNode(inputArr[mid]);
        root.left = sortedArrayToBSTHelper(start, mid-1);
        root.right = sortedArrayToBSTHelper(mid+1,end);

        return root;
    }
}
