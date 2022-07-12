class Solution {
    public boolean makesquare(int[] matchsticks) {
        int n = matchsticks.length;
        if(n < 4){ return false; }

        int total = 0;
        for(int i = 0; i < n; i++) total += matchsticks[i];
        if(total % 4 != 0) return false;

        Arrays.sort(matchsticks);
        int target = total/4;
        if(matchsticks[n-1] > total/4) return false;

        return dfs(matchsticks, new int[4], n-1, target);

    }

    public boolean dfs(int[] matchsticks, int[] sums, int idx, int target){
        if(idx == 0){
            if(sums[0] == target && sums[1] == target && sums[2] == target){ return true; }
            else{ return false; }
        }

        for(int i=0; i < 4; i++){
            if(sums[i] + matchsticks[idx] > target){ continue; }
            sums[i] += matchsticks[idx];
            if(dfs(matchsticks, sums, idx-1, target)) return true;
            sums[i] -= matchsticks[idx];
        }
        return false;
    }
}