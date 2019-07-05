class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Arrays.asList(new Integer[]{0});
        }
        // build a graph
        Set<Integer>[] graph = new Set[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new HashSet<>();
        }
        for (int[] edge: edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        // bfs
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (graph[i].size() == 1) {
                leaves.add(i);
            }
        }
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i: leaves) {
                int next = graph[i].iterator().next();
                graph[next].remove(i);
                 if (graph[next].size() == 1) {
                     newLeaves.add(next);
                 }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}