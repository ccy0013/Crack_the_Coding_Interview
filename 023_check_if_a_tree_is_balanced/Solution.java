/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Mon Aug 17 17:49:59 2015
 ************************************************************************/

/* Implement a function to check if a binary tree is balanced. For the
 * purposes of this question, a balanced tree is defined to be a tree such
 * that the heights of the two subtrees of any node never differ by more
 * than one.
 */

import java.util.LinkedList;

public class Solution{

	// A better solution with O(N) time complexity
	public static int isBalancedX( BinaryTreeNode root ){
		if( null == root )
			return 0;

		int leftHeight = isBalancedX( root.leftChild );
		int rightHeight = isBalancedX( root.rightChild );
		if( -1==leftHeight || -1==rightHeight )
			return -1;

		if( Math.abs(leftHeight-rightHeight) > 1 )
			return -1;

		return 1+Math.max( leftHeight, rightHeight );
	}

	// The most direct way to solve the problem
	// O(NlogN) time complexity
	public static boolean isBalanced( BinaryTreeNode root ){

		if( null == root )
			return true;

		return isBalanced( root.leftChild ) && isBalanced( root.rightChild ) && Math.abs(findHeight(root.leftChild)-findHeight(root.rightChild))<=1;
	}

	public static int findHeight( BinaryTreeNode root ){
		
		if( null == root )
			return 0;

		return 1+Math.max(findHeight(root.leftChild), findHeight(root.rightChild));
	}

	public static void main( String[] args ){

		BinaryTreeNode tree1 = new BinaryTreeNode( 0 );
		BinaryTreeNode[] nodes = new BinaryTreeNode[9];

		for( int i=0; i<nodes.length; i++ )
			nodes[i] = new BinaryTreeNode(i+1);

		tree1.leftChild = nodes[0];
		tree1.rightChild = nodes[1];

		for( int i=0; i<3; i++ ){
			nodes[i].leftChild = nodes[2*i+2];
			nodes[i].rightChild = nodes[2*i+3];
		}
		nodes[3].leftChild = nodes[8];

		tree1.print();

		//tree1.printByLayer();
		
		System.out.println( isBalanced(tree1) );

		BinaryTreeNode tree2 = new BinaryTreeNode( 0 );
		BinaryTreeNode[] nodes2 = new BinaryTreeNode[10];

		for( int i=0; i<nodes2.length; i++ )
			nodes2[i] = new BinaryTreeNode(i+1);

		tree2.leftChild = nodes2[0];
		tree2.rightChild = nodes2[1];

		nodes2[0].leftChild = nodes2[2];
		nodes2[0].rightChild = nodes2[3];
		nodes2[1].leftChild = nodes2[4];
		nodes2[1].rightChild = nodes2[5];
		nodes2[2].leftChild = nodes2[6];
		nodes2[2].rightChild = nodes2[7];
		nodes2[7].rightChild = nodes2[8];
		nodes2[4].leftChild = nodes2[9];

		tree2.print();

		System.out.println( isBalanced(tree2) );

		System.out.println( "-----------------Results by using isBalancedX---------------------" );
		tree1.print();
		System.out.println( -1!=isBalancedX(tree1) );
		tree2.print();
		System.out.println( -1!=isBalancedX(tree2) );
	}
}

class BinaryTreeNode{

	public int data;
	public BinaryTreeNode leftChild;
	public BinaryTreeNode rightChild;

	BinaryTreeNode(){
		data = 0;
		leftChild = null;
		rightChild = null;
	}

	BinaryTreeNode( int d ){
		data = d;
		leftChild = null;
		rightChild = null;
	}

	public void print(){
		printHelper( this );
		System.out.println( "" );
	}

	public void printHelper( BinaryTreeNode root ){

		if( null == root ){
			System.out.print( "/" + " " );
			return;
		}

		System.out.print( root.data + " " );

		if( null != root.leftChild ||  null != root.rightChild ){
			printHelper( root.leftChild );
			printHelper( root.rightChild );
		}
	}

	public void printByLayer(){
		LinkedList<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();

		System.out.println( this.data );

		queue.add( this );

		while( !queue.isEmpty() ){
			BinaryTreeNode temp = queue.remove(0);

			if( null != temp.leftChild ){
				System.out.print( temp.leftChild.data + " " );
				queue.add( temp.leftChild );
			}

			if( null != temp.rightChild ){
				System.out.println( temp.rightChild.data );
				queue.add( temp.rightChild );
			}
		}
	}
}
