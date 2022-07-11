class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, 0, list);
        return list;
    }

    public void dfs(TreeNode root, int level, List<Integer> list){
        if(root == null){ return; }
        if(list.size() == level){ list.add(root.val); }
        dfs(root.right, level+1, list);
        dfs(root.left, level+1, list);
    }
}