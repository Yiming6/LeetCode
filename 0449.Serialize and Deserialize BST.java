/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    /*
        Serialize the tree to string and decode it in preorder traversal.
        O(n), O(n).
    */

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serializeHelper(root, new String());
    }
    
    private String serializeHelper(TreeNode root, String str) {
        if (root == null) return str += "null,";
        
        str += String.valueOf(root.val) + ",";
        
        str = serializeHelper(root.left, str);
        str = serializeHelper(root.right, str);
        
        return str;
    }

    int curr;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        curr = 0;
        
        return deserializeHelper(arr);
    }
    
    private TreeNode deserializeHelper(String[] arr) {
        if (curr >= arr.length) return null;
        
        if (arr[curr].equals("null")) {curr++; return null;}
        
        TreeNode root = new TreeNode(Integer.parseInt(arr[curr++]));
        root.left = deserializeHelper(arr);
        root.right = deserializeHelper(arr);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;