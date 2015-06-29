/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Mon Jun 22 14:35:33 2015
 ************************************************************************/

//Problem Description
//Implement an algorithm to find the kth to last element of a singly linked list

public class Solution{

	//The most direct method, suitable when the size of list is given
	public static int findWithLength( Node list, int k ){
		int seq = list.size - k;

		Node p = list;

		for( int i=1; i<seq; i++ )
			p = p.next;

		return p.data;
	}

	//The following two methods can be used when we don't know the list size
	//The first one is a recursive method with O(n) time complexity and O(n) space complexity
	public static int findRecursively( Node list, int k ){
		Node node = new Node();

		distance2Last( list, k, node );

		return node.data;
	}

	public static int distance2Last( Node list, int k, Node n ){
		if( null == list.next )
			return 0;

		int distance = 1 + distance2Last( list.next, k, n );
		
		if( k == distance )
			n.data = list.data;
		
		return distance;
	}

	//The second one is an iterative method with O(n) time complexity and O(1) space complexity
	public static int findIteratively( Node list, int k ){
		Node p1 = list;
		Node p2 = list;

		for( int i=0; i<k; i++ )
			p2 = p2.next;

		while( null != p2.next ){
			p1 = p1.next;
			p2 = p2.next;
		}

		return p1.data;
	}


	public static void main( String[] args ){

		Node list = new Node(5);
		list.add(2).add(8).add(13).add(2).add(7).add(5);
		list.print();

		System.out.println( "[METHOD 1]" );
		System.out.println( "The 3rd to last element is: " + findWithLength( list, 3 ) );
		
		System.out.println( "[METHOD 2]" );
		System.out.println( "The 3rd to last element is: " + findRecursively( list, 3 ) );
	
		System.out.println( "[METHOD 3]" );
		System.out.println( "The 3rd to last element is: " + findIteratively( list, 3 ) );	
	}

}

class Node{
	public int data;
	public Node next;
	public int size;

	Node(){
		data = 0;
		next = null;
		size = 1;
	}

	Node( int d ){
		data = d;
		next = null;
		size = 1;
	}

	public Node add( int d ){
		Node p = this;

		while( null != p.next ){
			p = p.next;
		}

		p.next = new Node(d);

		++size;

		return this;
	}

	public void print(){
		Node p = this;
		
		System.out.print( "[List]: " );
		
		while( null != p.next ){
			System.out.print( p.data + "->" );
			p = p.next;
		}
	
		System.out.println( p.data );
	}
}
