/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Wed Aug 26 21:12:32 2015
 ************************************************************************/

/* You are given a binary tree in which each node contains an integer value 
 * (which might be positive or negative). Design an algorithm to print all 
 * paths which sum to a given value. The path does not need to start or end 
 * at the root or a leaf, but it mush go in a straight line down.
 */

import java.util.LinkedList;
import java.util.Stack;

public class Solution{

	public static void print( LinkedList<Stack<Node>> result, int sum ){

		//Delete the last item in the list, which is always empty
		result.pollLast();

		System.out.println( "[Sum " + sum + "]: " );
		if( 0 == result.size() )
			System.out.println( "The given tree doesn't have a path whose sum equals to " + sum );

		for( Stack<Node> s : result ){
			if( 0 == s.size() )
				continue;

			System.out.print( "  [Path]: " );
			for( Node n : s ){
				System.out.print( n.data + " " );
			}
			System.out.println( "" );
		}
	}

	public static boolean findPathHelper( Node root, int sum, LinkedList<Stack<Node>> result  ){

		if( null == root || root.data > sum )
			return false;

		result.peekLast().push( root );

		if( root.data == sum ){
			Stack<Node> temp = (Stack<Node>)result.peekLast().clone();
			temp.pop();
			result.add( temp );
			return true;
		}

		boolean b1 = findPathHelper( root.left, sum-root.data, result );
		boolean b2 = findPathHelper( root.right, sum-root.data, result );

		result.peekLast().pop();

		return b1 || b2;
	}

	public static void findPath( Node root, int sum, LinkedList<Stack<Node>> result ){
		
		if( null == root )
			return;

		findPathHelper( root, sum, result );

		findPath( root.left, sum, result );
		findPath( root.right, sum, result );
	}

	public static void main( String[] args ){

		LinkedList<Stack<Node>> paths = new LinkedList<Stack<Node>>();

		paths.offer( new Stack<Node>() );

		Node tree = new Node();
		Node[] nodes = new Node[10];

		for( int i=0; i<nodes.length; i++ )
			nodes[i] = new Node(i+1);

		tree.left = nodes[0];
		tree.right = nodes[1];

		nodes[0].left = nodes[2];
		nodes[0].right = nodes[3];

		nodes[1].left = nodes[4];
		nodes[1].right = nodes[5];

		nodes[2].left = nodes[9];
		nodes[3].right = nodes[8];
		nodes[4].right = nodes[6];
		nodes[5].left = nodes[7];

		tree.print();
		
		int sum = 20;

		findPath( tree, sum, paths );
		print( paths, sum );

		sum = 8;
		paths.clear();
		paths.add( new Stack<Node>() );
		findPath( tree, sum, paths );
		print( paths, sum );

		sum = 14;
		paths.clear();
		paths.add( new Stack<Node>() );
		findPath( tree, sum, paths );
		print( paths, sum );
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
