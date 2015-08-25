/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Tue Aug 25 14:20:37 2015
 ************************************************************************/

/* Design an algorithm and write code to find the first common ancestor of 
 * two nodes in a binary tree. Avoid storing additional nodes in a data 
 * structure. NOTE: This is not necessarily a binary search tree.
 */

public class Solution{

	public static boolean contains( Node root, Node node ){

		if( null == node || null == root )
			return false;

		if( root == node )
			return true;

		return contains( root.left, node ) || contains( root.right, node );
	}

	public static Node firstCommonAncestor( Node root,  Node node1, Node node2 ){

		boolean firstNodeOnLeft = contains( root.left, node1 );
		boolean secondNodeOnLeft = contains( root.left, node2 );

		if( firstNodeOnLeft && secondNodeOnLeft )
			return firstCommonAncestor( root.left, node1, node2 );
		else if( !firstNodeOnLeft && !secondNodeOnLeft )
			return firstCommonAncestor( root.right, node1, node2 );

		return root;
	}
	public static void main( String[] args ){

		Node tree = new Node();

		Node[] nodes = new Node[10];

		for( int i=0; i<nodes.length; i++ )
			nodes[i] = new Node(i+1);

		tree.left = nodes[0];
		tree.right = nodes[1];

		nodes[0].left = nodes[2];
		nodes[0].right = nodes[3];

		nodes[1].right = nodes[4];

		nodes[3].left = nodes[5];
		nodes[3].right = nodes[6];

		nodes[4].left = nodes[7];
		nodes[4].right = nodes[8];

		nodes[6].left = nodes[9];

		tree.print();
		
		//System.out.println( contains(tree, nodes[9]) );
		System.out.println( "The first common ancestor of node 3 and 6 is: " + firstCommonAncestor(tree,nodes[2],nodes[5]).data );
		System.out.println( "The first common ancestor of node 1 and 2 is: " + firstCommonAncestor(tree,nodes[0],nodes[1]).data );
		System.out.println( "The first common ancestor of node 4 and 5 is: " + firstCommonAncestor(tree,nodes[3],nodes[4]).data );
		System.out.println( "The first common ancestor of node 6 and 10 is: " + firstCommonAncestor(tree,nodes[5],nodes[9]).data );
		System.out.println( "The first common ancestor of node 8 and 10 is: " + firstCommonAncestor(tree,nodes[7],nodes[9]).data );
		System.out.println( "The first common ancestor of node 7 and 10 is: " + firstCommonAncestor(tree,nodes[6],nodes[9]).data );
	}
}

class Node{

	public int data;
	public Node left;
	public Node right;

	Node(){
		data = 0;
		left = right = null;
	}

	Node( int d ){
		data = d;
		left = right = null;
	}

	public void print(){
		System.out.print( "[Tree]: " );
		printHelper( this );
		System.out.println( "" );
	}

	private void printHelper( Node root ){
		if( null == root ){
			System.out.print( "# " );
			return;
		}

		System.out.print( root.data + " " );
		
		printHelper( root.left );
		printHelper( root.right );
	}
}
