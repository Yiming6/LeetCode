/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode str2tree(String s) {
        if (s.length() == 0) return null;
        
        StringBuilder sb = new StringBuilder();
        int l = 0;
        while (l < s.length() && s.charAt(l) != '(' && s.charAt(l) != ')') {
            sb.append(s.charAt(l++));
        }
        
        int counter = 0, r = l + 1;
        for (int i = l; i < s.length(); i++) {
            if (s.charAt(i) == '(') counter++;
            if (s.charAt(i) == ')') counter--;
            
            if (counter == 0) {
                r = i;
                break;
            }
        }
        
        String left = l == r - 1 ? "" : s.substring(l + 1, r);
        String right = r >= s.length() - 3 ? "" : s.substring(r + 2, s.length() - 1);
        
        TreeNode root = new TreeNode(Integer.valueOf(sb.toString()));
        root.left = str2tree(left);
        root.right = str2tree(right);
        
        return root;
    }
}