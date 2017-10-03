package LeetCode.WeeklyContest;

import java.util.HashSet;
import java.util.Stack;

public class WeeklyContest52 {
    public int repeatedStringMatch(String A, String B) {
        int count = 0, i = 0, j = 0, length = 0;
        HashSet<Character> set = new HashSet<>();
        for (char c : A.toCharArray()) set.add(c);
        while (i != B.length()) {
            if (!set.contains(B.charAt(i))) return -1;
            if (A.charAt(j) != B.charAt(i)) {
                i++;
                j=0;
                continue;
            } else {
                j++;
                i++;
            }
            length++;
            if (j == A.length()) {
                if (length > A.length()) count +=2;
                else count++;
                j = 0;
                length = 0;
            }
        }
        if (j != 0) count++;
        return count;
    }

    int maxLength;
    public int longestUnivaluePath(TreeNode root) {
        maxLength = 0;
        longestUnivaluePathHelper(root);
        return maxLength;
    }

    private int longestUnivaluePathHelper(TreeNode root) {
        if (root == null) return 0;

        int left = longestUnivaluePathHelper(root.left);
        int right = longestUnivaluePathHelper(root.right);
        if (root.left != null && root.left.val == root.val && root.right != null && root.right.val == root.val) {
            int length = Math.max(left + 1, right + 1);
            maxLength = Math.max(maxLength, left + right + 2);
            return length;
        } else if (root.left != null && root.left.val == root.val ) {
            maxLength = Math.max(maxLength, left + 1);
            return left + 1;
        } else if (root.right != null && root.right.val == root.val) {
            maxLength = Math.max(maxLength, right + 1);
            return right + 1;
        } else {
            return 0;
        }
    }
}
