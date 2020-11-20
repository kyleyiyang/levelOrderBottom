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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root==null) return ans;
        ans.add(new ArrayList<Integer>(Arrays.asList(root.val)));
        int level=0;
        traversal(root,ans,level);
        //Collections.reverse(ans);
        return ans;
    }
    public static void traversal(TreeNode node, List<List<Integer>> ans, int level) {
        level++;
        List<Integer> temp=new ArrayList<>();
        if (node!=null) {
            
            if (node.left!=null) temp.add(node.left.val);
            if (node.right!=null) temp.add(node.right.val);
            if (temp.size()>0) {
                if (ans.size()>level) {
                    List<Integer> re = ans.get(ans.size()-level-1);
                    List<Integer> newList = Stream.concat(re.stream(), temp.stream()).collect(Collectors.toList());
                    ans.set(ans.size()-level-1, newList);
                } else {
                    ans.add(0,temp);
                }
            }
            traversal(node.left, ans, level);
            traversal(node.right, ans, level);
        }
    }
}
