class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // build a graph in form of adjacency list and inDegree array
        List<Integer>[] graph = new List[numCourses];
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int[] pair: prerequisites) {
            int to = pair[0];
            int from = pair[1];
            graph[from].add(to);
            inDegree[to]++;
        }
        
        // topo sort
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int v = q.poll();
            count++;
            for (int n: graph[v]) {
                inDegree[n]--;
                if (inDegree[n] == 0) {
                    q.add(n);
                }
            }
        }
        return count == numCourses;
    }
}