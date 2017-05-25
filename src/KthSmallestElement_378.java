import java.util.PriorityQueue;

/**
 * Created by xiaoxiao on 5/24/17.
 */
public class KthSmallestElement_378 {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < matrix.length;i++) {
            pq.offer(new Node(0,i,matrix[0][i]));
        }
        for (int i =0; i < k-1;i++) {
            Node node = pq.poll();
            if (node.x == matrix.length-1) continue;
            pq.offer(new Node(node.x+1,node.y,matrix[node.x+1][node.y]));
        }
        return pq.poll().val;
    }

    private static class Node implements Comparable<Node>{
        int x,y,val;
        Node (int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Node node) {
            return this.val - node.val;
        }
    }
}
