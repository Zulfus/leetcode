class Solution {

    public int maxAreaOfIsland(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int max = 0;

        for(int i=0; i < n; i++){
            for(int j=0; j < m; j++){
                max = Math.max(max, dfs(i, j, grid));
            }
        }

        return max;
    }

    public int dfs(int i, int j, int[][] grid){

        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1){
            grid[i][j] = 0;
            return 1 + dfs(i+1, j, grid) + dfs(i-1, j, grid) + dfs(i, j+1, grid) + dfs(i, j-1, grid);
        }

        return 0;
    }
}