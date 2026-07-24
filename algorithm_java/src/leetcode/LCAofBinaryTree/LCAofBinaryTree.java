package leetcode.LCAofBinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LCAofBinaryTree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root,p,q);
    }
    TreeNode dfs(TreeNode cur, TreeNode p, TreeNode q){
        if(cur == null) return null;
        if(cur == p || cur == q){
            return cur;
        }
        List<TreeNode> found = new ArrayList<>();
        TreeNode res1 = dfs(cur.left,p,q);
        TreeNode res2 = dfs(cur.right,p,q);
        if(res1!=null) found.add(res1);
        if(res2!=null) found.add(res2);

        if(found.size()==1){
            return found.get(0);
        }
        if(found.size()==2){
            return cur;
        }
        return null;
    }
}
