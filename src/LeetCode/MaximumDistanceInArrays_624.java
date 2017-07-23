import java.util.List;

public class MaximumDistanceInArrays_624 {
    public int maxDistance(List<List<Integer>> arrays) {
        int maxDist = 0;
        int left = arrays.get(0).get(0), right = arrays.get(0).get(arrays.get(0).size()-1);
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> currArray = arrays.get(i);
            maxDist = Math.max(Math.max(Math.abs(currArray.get(currArray.size()-1) - left), Math.abs(currArray.get(0) - right)), maxDist);
            left = Math.min(currArray.get(0), left);
            right = Math.max(currArray.get(currArray.size()-1), right);
        }
        return maxDist;
    }
}
