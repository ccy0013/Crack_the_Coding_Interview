/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Wed Jun 17 20:31:42 2015
 ************************************************************************/

//Problem Description
//Write code to remove duplicates from an unsorted linked list
//[FOLLOW UP] How could you solve this problem if a temporary buffer is not allowed

import java.util.HashSet;

public class Solution{

	//Solution with a buffer, which takes O(n) time and O(n) space
	public static void deduplicate( Node list ){

		//If the list has only one node
		//Equivalent to "if( 1 == list.size() )"
		if( null == list.next )
			return;

		HashSet<Integer> set = new HashSet<Integer>();

		Node p = list;

		set.add( p.data );

		while( null != p.next ){
			if( set.contains( p.next.data ) )
				p.next = p.next.next;
			else{
				set.add( p.next.data );
				p = p.next;
			}
		}
	}

	//Solution without buffer, which takes O(n^2) time and O(1) space
	public static void deduplicateWithoutBuffer( Node list ){
		
		if( null == list.next )
			return;

		Node p1 = list, p2 = p1;
		
		while( null != p1 && null != p1.next  ){
			p2 = p1;
			while( null != p2.next ){
				if( p2.next.data == p1.data )
					p2.next = p2.next.next;
				else
					p2 = p2.next;
			}
			p1 = p1.next;
		}
	}

	public static void main( String[] args ){

		System.out.print("[ORIGINAL]");
		Node list1 = new Node(1);
		list1.add(5).add(3).add(2).add(3).add(1).add(0).add(6).add(6).add(3);
		list1.print();

		System.out.print( "[Deduplicated]" );
		deduplicate( list1 );
		list1.print();

		System.out.print( "[ORIGINAL]" );
		Node list2 = new Node(1);
		list2.add(5).add(3).add(2).add(3).add(1).add(0).add(6).add(6).add(3);
		list2.print();

		System.out.print( "[Deduplicated (no buffer)]" );
		deduplicateWithoutBuffer( list2 );
		list2.print();

	}
		
}

class Node{
	public int data;
	public Node next;
	private int size;

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

		p.next =  new Node(d);
		
		++size;

		return this;
	}

	public int size(){
		return this.size;
	}

	public void print(){
	
		if( 1 == this.size ){
			System.out.println( "[List]: " + this.data );
			return;
		}
		
		Node p = this;

		System.out.print( "[List]: " );
		while( null != p.next ){
			System.out.print( p.data + "->"  );
			p = p.next;
		}
		System.out.println( p.data );
	}
		
}
	
