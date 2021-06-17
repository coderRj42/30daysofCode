public class Solution{

static class MaxPairNode<T>{
    int sum;	
    TreeNode<T> node;
}

    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
        return MaxPairNodeHelper(root).node;
    }
    
    public static MaxPairNode<Integer> MaxPairNodeHelper(TreeNode<Integer> root){
        if(root == null){
            MaxPairNode<Integer> pair = new MaxPairNode<>();
            pair.node = null;
            pair.sum = Integer.MIN_VALUE;
            return pair;
        }
        
        int sum = root.data;
        for(int i=0; i<root.children.size(); i++)
            sum += root.children.get(i).data;
        
        
        MaxPairNode<Integer> pair = new MaxPairNode<>();
        pair.sum = sum;
        pair.node = root;
        
        for(int i=0; i<root.children.size(); i++)
        {
        	MaxPairNode<Integer> temp = MaxPairNodeHelper(root.children.get(i));
            if(temp.sum > pair.sum)
                pair = temp;
        }
        
        return pair;
    }
    
}
