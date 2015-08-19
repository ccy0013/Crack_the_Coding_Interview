/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Tue Aug 18 16:50:24 2015
 ************************************************************************/

/* Given a sorted (increasing order) array with unique integer elements, 
 * write an algorithm to create a binary search tree with minimum height.
 */

import java.util.Arrays;

public class Solution{

	public static BinaryTreeNode buildBST( int[] array, int start, int end ){
		
		if( null == array || end<start )
			return null;

		int mid = (start+end)/2;
		BinaryTreeNode root = new BinaryTreeNode( array[mid] );

		root.left = buildBST( array, start, mid-1 );
		root.right = buildBST( array, mid+1, end );

		return root;
	}

	public static void main( String[] args ){
		
		int[] array = { -10, -7, -1, 0, 4, 9, 11, 27, 53, 100, 233 };
		//int[] array = {0, 1, 2, 3};
		BinaryTreeNode tree = buildBST( array, 0, array.length-1 );

		System.out.println( "[Array]: " + Arrays.toString(array) );
		tree.print();
	}
}

class BinaryTreeNode{

	public int data;

	public BinaryTreeNode left;
	public BinaryTreeNode right;

	BinaryTreeNode(){
		data = Integer.MIN_VALUE;
		left = null;
		right = null;
	}

	BinaryTreeNode( int d ){
		data = d;
		left = null;
		right = null;
	}

	public void print(){
		System.out.print( "[Tree]: " );
		printHelper( this );	
		System.out.println( "" );
	}

	public void printHelper( BinaryTreeNode root ){
		if( null == root ){
			System.out.print( "# " );
			return;
		}

		System.out.print( root.data + " " );

		printHelper( root.left );
		printHelper( root.right );
	}
}
