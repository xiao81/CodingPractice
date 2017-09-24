package Assignments;

import java.util.*;

public class Assignment6 {
    //Q1 Binary Search logN
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid > 0 && nums[mid - 1] > nums[mid]) return nums[mid];
            if (nums[end] < nums[mid]) start = mid + 1;
            else end = mid - 1;
        }
        return nums[start];
    }

    //Q2
    public int searchInArray(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return  nums[0] == target ? 0 : -1;

        int mid = nums.length / 2;
        int left = binarySearch(nums, target, 0, mid, false);
        int right = binarySearch(nums,target, mid + 1, nums.length - 1, true);
        return left != -1 ? left : right;
    }

    public int binarySearch(int[] nums, int target, int start, int end, boolean isInc) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            if (isInc) {
                if (target < nums[mid]) end = mid - 1;
                else start = mid + 1;
            } else {
                if (target < nums[mid]) start = mid + 1;
                else end = mid - 1;
            }
        }
        return -1;
    }

    //Q3
    public int[] find3Numbers(int[] nums, int sum) {
        Arrays.sort(nums);
        int left, right;
        for (int i = 0; i < nums.length - 2; i++) {
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == sum) {
                    return new int[]{nums[i],nums[left],nums[right]};
                } else  if (nums[i] + nums[left] + nums[right] < sum) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return null;
    }

    //Q4
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int first = 0, second = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        while (second < nums.length) {
            sum += nums[second++];
            while (sum >=s){
                minLength = Math.min(second - first, minLength);
                sum -= nums[first++];
            }

        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    //Q5
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int maxSum = nums[0];
        dp[0]= nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] > 0 ? nums[i] + dp[i - 1] : nums[i];
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }

    //Q6
    public int maxProduct(int[] nums) {
        int maxSum = nums[0], max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = max;
                max = Math.max(min*nums[i], nums[i]);
                min = Math.min(temp*nums[i], nums[i]);
            } else {
                max = Math.max(max*nums[i], nums[i]);
                min = Math.min(min*nums[i], nums[i]);
            }
            maxSum = Math.max(maxSum, max);
        }
        return maxSum;
    }

    //Q7
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, start = 0, end = Integer.MAX_VALUE;
        int counter = t.length();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0) + 1);
        }
        while (right != s.length()) {
            if (map.containsKey(s.charAt(right))) {
                if (map.get(s.charAt(right)) > 0) {
                    counter--;
                }
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
            }
            right++;
            while (counter == 0) {
                if (right - left < end - start) {
                    end = right;
                    start = left;
                }
                if (map.containsKey(s.charAt(left))) {
                    if (map.get(s.charAt(left)) == 0) {
                        counter++;
                    }
                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                }
                left++;
            }
        }
        return end == Integer.MAX_VALUE ? "" : s.substring(start, end);
    }

    //Q8
    //Moore Voting Algorithm
    public int majorityElement(int[] nums) {
        int count = 1;
        int majorIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[majorIndex] == nums[i]) count++;
            else count--;
            if (count == 0) {
                majorIndex = i;
                count = 1;
            }
        }
        return nums[majorIndex];
    }

    //Q9
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            int j = i;
            int count = 0;
            int tank = 0;
            while (count != gas.length) {
                tank += gas[j] - cost[j];
                j = j + 1 == gas.length ? 0 : j + 1;
                if (tank < 0) break;
                count++;
            }
            if (count == gas.length) return i;
        }
        return -1;
    }

    //Q10
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = String.valueOf(charArray);
            map.putIfAbsent(sortedStr, new ArrayList<>());
            map.get(sortedStr).add(str);
        }
        for (List<String> list : map.values()) {
            result.add(list);
        }
        return result;
    }

    //Q11
    public void setZeroes(int[][] matrix) {
        boolean col0 = false;
        int row = matrix.length, col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) col0 = true;
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
            if (col0) matrix[i][0] = 0;
        }
    }
    //Q12
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        if (matrix[0] == null || matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0, end = m * n -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == matrix[mid/n][mid%n]) return true;
            else if (target < matrix[mid/n][mid%n]) end = mid - 1;
            else start = mid + 1;
        }
        return false;
    }

    //Q13
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> resultList = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return resultList;
        if (matrix[0].length == 0) return resultList;
        int m = matrix.length;
        int n = matrix[0].length;
        int cnt = 0;
        while (resultList.size() < m * n) {

            for (int i = cnt; i < n - cnt; i++) {
                resultList.add(matrix[cnt][i]);
            }
            for (int i = cnt + 1; i < m - cnt; i++) {
                resultList.add(matrix[i][n - cnt - 1]);
            }
            if (cnt + 1 != m - cnt) {
                for (int i = n - cnt - 2; i >= cnt; i--) {
                    resultList.add(matrix[m - cnt - 1][i]);
                }
            }
            if (cnt + 1 != n - cnt) {
                for (int i = m - cnt - 2; i >= cnt + 1; i--) {
                    resultList.add(matrix[i][cnt]);
                }
            }

            cnt++;
        }
        return resultList;
    }
    //Q14
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax =0, rightMax = 0;
        int result = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    result += (leftMax - height[left]);
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    result += (rightMax - height[right]);
                }
                right--;
            }
        }
        return result;
    }

    //Q15
    public boolean zeroSumSubarray(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int currSum = 0;
        for (int num : nums) {
            currSum += num;
            if (set.contains(currSum)) return true;
            else set.add(currSum);
        }
        return false;
    }

    //Q16
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        int i = 0, j = 0;
        while (i != nums1.length || j != nums2.length) {
            int num = i != nums1.length ? nums1[i] : nums2[j];
            if (minHeap.size() == 0 || maxHeap.size() == 0) {
                minHeap.offer(num);
            } else {
                if (num > minHeap.peek()) maxHeap.offer(num);
                else minHeap.offer(num);
            }

            if (minHeap.size() - maxHeap.size() >= 2) maxHeap.offer(minHeap.poll());
            if (maxHeap.size() - minHeap.size() >= 2) minHeap.offer(maxHeap.poll());
        }

        if (minHeap.size() == maxHeap.size()) {
            return (double)(minHeap.peek() + maxHeap.peek()) / 2;
        } else {
            return maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
        }

    }

    //Q17
    public int[] findPairs(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i] + k)){
                return new int[] {nums[i] + k, nums[i]};
            } else if (set.contains(nums[i] - k)) {
                return new int[] {nums[i] - k, nums[i]};
            } else {
                set.add(nums[i]);
            }
        }
        return null;
    }
    //Q18
    public void sortColors(int[] nums) {
        int head = 0;
        int tail = nums.length - 1;
        for (int i = 0; i <= tail; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[head];
                nums[head++] = 0;
            }
            if (nums[i] == 2) {
                nums[i--] = nums[tail];
                nums[tail--] = 2;
            }
        }
    }

}
