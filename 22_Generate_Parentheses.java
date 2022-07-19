class Solution {
    public List<String> generateParenthesis(int n) {
        List<List<String>> res = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        tmp.add("");
        res.add(tmp);

        for(int i=1; i <= n; i++){
            List<String> list = new ArrayList<>();

            for(int j=0; j < i; j++){
                List<String> l1 = res.get(j);
                List<String> l2 = res.get(i-j-1);

                for(String s : l1){
                    for(String s1 : l2){
                        list.add("(" + s + ")" + s1);
                    }
                }

            }
            res.add(list);
        }

        return res.get(n);

    }

}