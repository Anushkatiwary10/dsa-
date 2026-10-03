class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Pacific: top row + left column
        for(int i = 0; i < m; i++) {
            dfs(i, 0, heights, pacific);
        }

        for(int j = 0; j < n; j++) {
            dfs(0, j, heights, pacific);
        }

        // Atlantic: bottom row + right column
        for(int i = 0; i < m; i++) {
            dfs(i, n - 1, heights, atlantic);
        }

        for(int j = 0; j < n; j++) {
            dfs(m - 1, j, heights, atlantic);
        }

        // Cells reachable from both oceans
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }

    public void dfs(int row, int col, int[][] heights, boolean[][] visited) {

        visited[row][col] = true;

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        for(int[] dir : directions) {

            int nr = row + dir[0];
            int nc = col + dir[1];

            // Boundary check
            if(nr < 0 || nr >= heights.length ||
               nc < 0 || nc >= heights[0].length) {
                continue;
            }

            // Already visited
            if(visited[nr][nc]) {
                continue;
            }

            // Reverse flow condition
            if(heights[nr][nc] < heights[row][col]) {
                continue;
            }

            dfs(nr, nc, heights, visited);
        }
    }
}