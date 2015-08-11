/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Mon Aug  3 21:17:19 2015
 ************************************************************************/

/*
 * Given a circular linked list, implement an algorithm which returns the node at the beginning of the loop.
 * EXAMPLE
 * Input: A -> B -> C -> D -> E -> C [The same C as earlier]
 * Output: C
*/

import java.util.HashSet;

public class Solution{

	public static Node findCircle( Node list ){

	HashSet<Integer> map = new HashSet<Integer>();

		Node temp = list;

		while(null != temp.next){
			int code = temp.hashCode();
			
			if( map.contains(code) )
				return temp;
			else
				map.add(code);

			temp = temp.next;
		}

		return null;
	}
	
	public static void main( String[] args ){

		Node list = new Node('A');
		list.add('B').add('C').add('D').add('E');

		list.tail.next = list.next.next;

		//list.print();
		Node result = findCircle( list );
		System.out.println( "[Node]: " + result.data );
	}
}

class Node{
	public char data;
	public Node next;
	public int size;

	public Node tail;

	Node(){
		data = 0;
		next = null;
		size = 0;
		tail = this;
	}

	Node( char c ){
		data = c;
		next = null;
		size = 0;
		tail = this;
	}

	public Node add( char d ){

		//Node temp = this;
		
		//while( null != temp.next )
			//temp = temp.next;

		//temp.next = new Node( d );

		tail = tail.next = new Node(d);
		++size;

		return this;
	}
	
	public void print(){

		Node temp = this;

		System.out.print( "[List]: " );

		while( null != temp.next ){
			System.out.print( temp.data + "->" );
			temp = temp.next;
		}

		System.out.println( temp.data );
	}

}
			
