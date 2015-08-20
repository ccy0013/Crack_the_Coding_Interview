/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Wed Aug 19 20:38:02 2015
 ************************************************************************/

/* Given a binary tree, design an algorithm which creates a linked list of 
 * all the nodes at each depth (e.g., if you have a tree with depth D, you'll
 * have D linked lists)
 */

import java.util.LinkedList;

public class Solution{

	//Print all the leaves first, like peeling an apple
	/*
	public static int getListsByLayer( BinaryTreeNode root, LinkedList<LinkedList<BinaryTreeNode>> result ){

		if( null == root )
			return 0;

		int height = 1 +  Math.max( getListsByLayer( root.left, result ), getListsByLayer( root.right, result ) );
	
		if( height >= result.size() ){
			result.offer( new LinkedList<BinaryTreeNode>() );
			result.peekLast().offer( root );
		}
		else
			result.get(height-1).offer( root );

		return height;
	}
	*/

	public static void getListsByLayer( BinaryTreeNode root, LinkedList<LinkedList<BinaryTreeNode>> result, int layer ){

		if( null == root )
			return;

		if( layer >= result.size() ){
			result.offer( new LinkedList<BinaryTreeNode>() );
			result.peekLast().offer( root );
		}
		else
			result.get(layer).offer( root );

		getListsByLayer( root.left, result, layer+1 );
		getListsByLayer( root.right, result, layer+1 );
	}

	public static void main( String[] args ){
		
		BinaryTreeNode tree = new BinaryTreeNode();

		BinaryTreeNode[] nodes = new BinaryTreeNode[9];
		for( int i=0; i<9; i++ )
			nodes[i] = new BinaryTreeNode( i+1 );

		tree.left = nodes[0];
		tree.right = nodes[1];

		nodes[0].left = nodes[2];
		nodes[0].right = nodes[3];
		nodes[2].right = nodes[4];
		nodes[4].left = nodes[5];
		nodes[1].left = nodes[6];
		nodes[1].right = nodes[7];
		nodes[7].left = nodes[8];

		tree.print();

		LinkedList<LinkedList<BinaryTreeNode>> result = new LinkedList<LinkedList<BinaryTreeNode>>();
		getListsByLayer( tree, result, 0 );

		for( int i=0; i<result.size(); i++ ){
			System.out.print( "[List " + i + "]: " );
			LinkedList<BinaryTreeNode> temp = result.get(i);
			for( int j=0; j<temp.size(); j++ )
				System.out.print( temp.get(j).data + " " );
			System.out.println( "" );
		}
	}
}

class BinaryTreeNode{

	public int data;
	public BinaryTreeNode left;
	public BinaryTreeNode right;

	BinaryTreeNode(){
		data = 0;
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

	private void printHelper( BinaryTreeNode root ){

		if( null == root ){
			System.out.print( "/ " );
			return;
		}

		System.out.print( root.data + " " );

		printHelper( root.left );
		printHelper( root.right );
	}
}
