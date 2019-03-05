package tree_linked;

public class LinkedTree {

	private TreeNode root;
	
	public TreeNode makeBT(TreeNode bt1, Object data, TreeNode bt2) {
		
		TreeNode root = new TreeNode();
		
		root.data = data;
		root.left = bt1;
		root.right = bt2;
		
		return root;
	}

	public void preorder(TreeNode root) {
		
		if (root != null) {
			
			System.out.printf("%c", root.data);
			preorder(root.left);
			preorder(root.right);
		}
	}

	public void inorder(TreeNode root) {
		
		if (root != null) {
			
			preorder(root.left);
			System.out.printf("%c", root.data);
			preorder(root.right);
		}
	}

	public void postorder(TreeNode root) {
		
		if (root != null) {
			
			preorder(root.left);
			preorder(root.right);
			System.out.printf("%c", root.data);
		}
	}
	
	
	
	
	
	
	
	
}
