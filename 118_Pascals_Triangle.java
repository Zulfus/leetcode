class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        res.add(tmp);

        for(int i=1; i < numRows; i++){
            tmp = new ArrayList<>();
            for(int j=0; j <= i; j++){
                if(j == 0){ tmp.add(res.get(i-1).get(0)); }
                else if(j == i){ tmp.add(res.get(i-1).get(tmp.size()-1)); }
                else{ tmp.add(res.get(i-1).get(j-1) + res.get(i-1).get(j)); }
            }
            res.add(tmp);
        }

        return res;
    }
}