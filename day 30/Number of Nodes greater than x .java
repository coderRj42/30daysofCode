 public class Solution {
 	public static int numNodeGreater(TreeNode<Integer> root,int x){

		if(root == null) return -1;
        
        int count = 0;
        if(x < root.data)
            count++;a
        for(int i=0; i<root.children.size(); i++)
            count += numNodeGreater(root.children.get(i), x);

        return count;
	}
	
}
