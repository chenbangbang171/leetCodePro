package main.java.test;

public class findSecondMinimumValue {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {

	}
	
	
	
	
	public static int findBigger(TreeNode root, int val) {
		 if (root == null) return -1;
		//每次递归进来先判断该root节点的值是否大于上面传来的值，若大于，直接返回该节点的值
		if (root.val > val ) {
			return root.val;
		}
		
		//若不大于则向下递归
		int left = findBigger(root.left, val);
		int right = findBigger(root.right, val);
		
		//核心，因为两个子节点若存在，则必然有一个子节点等于该根节点，则该分支的所有返回值必为-1  
		//若该分支返回值为-1，则舍弃该分支，取另一分支的值，若都为-1或者都不是-1，则取两者较小者
		//这个不为-1的较小值，在接近整个二叉树的根节点时，一定是第二小或者和根节点一样是最小的
		if(left < 0) return right;
		if(right < 0) return left;
		return Math.min(left,right);
	}

}
