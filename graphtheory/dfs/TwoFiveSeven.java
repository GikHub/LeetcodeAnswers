package graphtheory.dfs;
import java.util.ArrayList;
import java.util.List;


public class TwoFiveSeven {
	private class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> resultList=new ArrayList<String>();
        if(root==null){
        	return resultList;
        }
        dfs(root,"", resultList);
        return resultList;
    }
	public void dfs(TreeNode node,String prefix,List<String> resultList){
		if(node==null){
			return;
		}
		if(node.left==null&&node.right==null){
			resultList.add(prefix+node.val);
			return;
		}
		prefix+=node.val+"->";
		dfs(node.left, prefix, resultList);
		dfs(node.right, prefix, resultList);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
