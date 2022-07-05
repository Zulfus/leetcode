class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n < 2){ return n; }

        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i < n; i++){
            set.add(nums[i]);
        }
        
        int max = 1;
        for(int i=0; i < n; i++){
            int num = nums[i];
            if(set.contains(num-1) && !set.contains(num+1)){
                int start = num;
                set.remove(num);
                num--;
                while(set.contains(num)){ set.remove(num); num--; }
                max = Math.max(max, start - num);
                if(set.isEmpty()){ return max; }
            }
        }
        
        return max;
    }
}

// Time compexlity: O(n)
// Space complexity: O(n)
// Add to set in O(1) time, check if item is member of set in O(logn), iterate nums and set in o(n). 

// Trival solution: sort in O(nlogn) time
