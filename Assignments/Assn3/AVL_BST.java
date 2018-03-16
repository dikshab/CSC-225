import java.util.*;

public class AVL_BST{
	
	public static boolean checkAVL(BST b){
		Node node;
		
		int left_height;
		int right_height;
		
		if(node == null)
			return true;
		
		left_height = height(node.left);
		right_height = height(node.right);
		
		if(Math.abs(left_height-right_height) <= 1 && checkAVL(node.left) && checkAVL(node.right))
			return true;

		return false;
	}
	
	int height(Node node){
		
		if(node == null)
			return 0;
		return 1+Math.max(height(node.left), height(node.right));
	}
	
	public static BST createBST(int[] a){
		
       	List<Integer> list = new ArrayList<Integer>();
		List<Node> nodes = new ArrayList<Node>();		
		BST bst = new BST();
		int n = a.length;
		int x = a[0];
		bst.root = new Node(x);		
		Node node = bst.root;		
		int i = 0;
		do {
			i++;
			if( i == a.length) {
				break;
			}
			if(a[i] < node.val && a[i] != -1) {
				node.left = new Node(a[i]);
				a[i] = -1;
				list.add(i);
				nodes.add(node.left);
				i++;
			}		
			while( node.val > a[i] && a[i] != -1) {
				i++;
			}		
			if(i < n && a[i] != -1) {
				node.right = new Node(a[i]);
				a[i] = -1;
				list.add(i);
				nodes.add(node.right);
			}
			if(list.isEmpty()) {
				break;
			}
			i = list.remove(0);		
			node = nodes.remove(0);
		}while(node != null);
		return bst;
	}


	

	public static void main(String[] args){
		int[] A = {5,2,8,6,1,9,52,3};
		BST b = createBST(A);
		System.out.println(checkAVL(b));
	}
}

class BST{

	Node root;
	
	public void add( int val ) {
		if( root == null ) {
			root = new Node(val);
		} else {
			root = add( root, val);
		}
	}
	
	private Node add( Node node, int val ) {
		if( node != null ) {
			if( node.val > val ) {
				node.left = add( node.left, val );
			} else {
				node.right = add( node.right, val);
			}
		} else {
			node = new Node( val );
		}
		return node;
	}
	
	public void preorder() {
		preorder(root);
	}
	
	public void preorder( Node node ) {
		if(node != null) {
			System.out.print(node.val + " ");
			preorder( node.left );
			preorder( node.right );
		}
	}
}

class Node {
	int val;
	Node left;
	Node right;
	
	public Node( int val ) {
		this.val = val;
	}
	
	public String toString() {
		return String.valueOf(val);
	}
}