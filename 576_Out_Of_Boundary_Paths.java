class Solution {
    int[][][] dp;
    int M = 1000000007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new int[m][n][maxMove+1];
        for(int i=0; i < m; i++){
            for(int j=0; j < n; j++){
                for(int k=0; k <= maxMove; k++){
                    dp[i][j][k] = -1;
                }
            }
        }

        return dfs(m,n,maxMove,startRow, startColumn);
    }

    public int dfs(int m, int n, int moves, int i, int j){
        if(i < 0 || i == m || j < 0 || j == n){ return 1; }
        if(moves == 0){ return 0; }
        if(dp[i][j][moves] != -1){ return dp[i][j][moves]; }

        dp[i][j][moves] = ((dfs(m, n, moves-1, i+1, j) + dfs(m, n, moves-1, i-1, j)) % M + (dfs(m, n, moves-1, i, j+1) + dfs(m, n, moves-1, i, j-1)) % M) % M;
        return dp[i][j][moves];
    }
}