class Solution {
    
    public class Node {
        int val;
        // 0 means red, 1 means blue
        int prevEdge;
        
        public Node(int val, int prevEdge) {
            this.val = val;
            this.prevEdge = prevEdge;
        }
    }
    
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        List<Integer>[] redMap = new List[n];
        List<Integer>[] blueMap = new List[n];
        for (int i = 0; i < red_edges.length; i++) {
            int[] edge = red_edges[i];
            if (redMap[edge[0]] == null) {
                redMap[edge[0]] = new ArrayList<>();
            }
            redMap[edge[0]].add(edge[1]);
            
        }
        for (int i = 0; i < blue_edges.length; i++) {
            int[] edge = blue_edges[i];
            if (blueMap[edge[0]] == null) {
                blueMap[edge[0]] = new ArrayList<>();
            }
            blueMap[edge[0]].add(edge[1]);
        }

        HashSet<String> visited = new HashSet<>();
        int d = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        q.add(new Node(0, 1));

        while (!q.isEmpty()) {
 
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                String key = curr.val + "/" + curr.prevEdge;
                if (visited.contains(key)) {
                    continue;
                }
                visited.add(key);
                if (answer[curr.val] == -1) {
                    answer[curr.val] = d;
                } else {
                    answer[curr.val] = Math.min(d, answer[curr.val]);
                }
                // prev edge is red, next should be blue
                if (curr.prevEdge == 0) {
                    if (blueMap[curr.val] != null) {
                        for (int next: blueMap[curr.val]) {
                            q.add(new Node(next, 1));
                        }
                    }
                    // prev edge is blue, next should be red
                } else {
                    if (redMap[curr.val] != null) {
                        for (int next: redMap[curr.val]) {
                            q.add(new Node(next, 0));
                        }
                    }
                }
            }
            d++;
        }
        return answer;
    }
}