class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        // build a graph and populate the inDegree array
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
            res[count] = v;
            count++;
            for (int n: graph[v]) {
                inDegree[n]--;
                if (inDegree[n] == 0) {
                    q.add(n);
                }
            }
        }
        if (count == numCourses) {
            return res;
        }
        return new int[0];
    }
}