class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // build a graph
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int[] pair: prerequisites) {
            int to = pair[0];
            int from = pair[1];
            graph[from].add(to);
        }
        
        // dfs
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, visited)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean dfs(int v, List<Integer>[] graph, int[] visited) {
        // is being visited, has cycle
        if (visited[v] == 1) {
            return false;
        }
        // hqs been visited
        if (visited[v] == -1) {
            return true;
        }
        visited[v] = 1;
        for (int n: graph[v]) {
            if (!dfs(n, graph, visited)) {
                return false;
            }
        }
        visited[v] = -1;
        return true;
    }
}