class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    q.offer(new int[]{i, j});
                    while (!q.isEmpty()) {
                        int[] pos = q.poll();
                        int x = pos[0];
                        int y = pos[1];
                        if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == '0') {
                            continue;
                        }
                        grid[x][y] = '0';
                        q.offer(new int[]{x + 1, y});
                        q.offer(new int[]{x - 1, y});
                        q.offer(new int[]{x, y + 1});
                        q.offer(new int[]{x, y - 1});
                    }
                    res++;
                }
            }
        }
        return res;
    }
}