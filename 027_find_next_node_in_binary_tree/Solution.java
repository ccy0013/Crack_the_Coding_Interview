/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Fri Aug 21 21:12:11 2015
 ************************************************************************/

/* Write an algorithm to find the 'next' node (i.e., in-order successor) of 
 * a given node in a binary search tree. You may assume that each node has 
 * a link to its parent
 */

public class Solution{

	public static boolean isRightChild( Node parent, Node child ){
		if( null == parent )
			return false;
		
		if( parent.right == child )
			return true;

		return false;
	}

	public static Node findNext( Node root ){

		if( null == root )
			return null;

		if( null == root.right ){
			Node temp = root;

			while( isRightChild( temp.parent, temp ) )
				temp = temp.parent;

			return temp.parent;
		}
		else
			return findNextDescendant( root.right );
	}

	public static Node findNextDescendant( Node root ){

		Node result;
		if( null == root )
			return null;

		if( null == root.left && null == root.right )
			return root;

		result = findNextDescendant( root.left );
		
		if( null == result )
			result = findNextDescendant( root.right );
	
		return result;
	}

	public static void main( String[] args ){

		Node result;

		Node tree = new Node();

		Node[] nodes = new Node[6];
		for( int i=0; i<nodes.length; i++ )
			nodes[i] = new Node( i+1 );
		
		tree.left = nodes[0];
		nodes[0].parent = tree;
		tree.right = nodes[1];
		nodes[1].parent = tree;

		tree.print();
		result = findNext(tree);
		System.out.println( "Next node of root is: " + ((null==result) ? "null" : result.data) );
		
		nodes[0].left = nodes[2];
		nodes[2].parent = nodes[0];
		nodes[2].right = nodes[3];
		nodes[3].parent = nodes[2];

		tree.print();
		result = findNext(nodes[2]);
		System.out.println( "Next node of 3 is: " + ((null==result) ? "null" : result.data) );

		tree.print();
		result = findNext(nodes[3]);
		System.out.println( "Next node of 4 is: " + ((null==result) ? "null" : result.data) );

		nodes[1].left = nodes[4];
		nodes[4].parent = nodes[1];
		nodes[1].right = nodes[5];
		nodes[5].parent = nodes[1];

		tree.print();
		result = findNext(nodes[4]);
		System.out.println( "Next node of 5 is: " + ((null==result) ? "null" : result.data) );

		tree.print();
		result = findNext(tree);
		System.out.println( "Next node of root is: " + ((null==result) ? "null" : result.data) );

		tree.print();
		result = findNext(nodes[1]);
		System.out.println( "Next node of 2 is: " + ((null==result) ? "null" : result.data) );
		
		tree.print();
		result = findNext(nodes[5]);
		System.out.println( "Next node of 6 is: " + ((null==result) ? "null" : result.data) );
	}

}

class Node{

	public int data;
	public Node left;
	public Node right;
	public Node parent;

	Node(){
		data = 0;
		left = right = parent = null;
	}

	Node( int d ){
		data = d;
		left = right = parent = null;
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
