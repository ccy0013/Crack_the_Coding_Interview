/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Tue Jun 30 11:30:10 2015
 ************************************************************************/

public class Solution{

	//Only swaps the value
	public static void partition( Node list, int flag ){
		Node p1 = list, p2 = p1;

		while( null != p2.next ){
			if( p2.data < flag ){

				if( p1 != p2 ){
					int temp = p2.data;
					p2.data = p1.data;
					p1.data = temp;

					p1 = p1.next;
				}
				else
					p2 = p2.next;
			}
			else
				p2 = p2.next;
		}

		if( p2.data < flag ){
			int temp = p2.data;
			p2.data = p1.data;
			p1.data = temp;
		}
	}

	//Treat each node as a whole
	public static void partitionComp( Node list, int flag ){

		Node list1Head = new Node();
		Node list1Tail = list1Head;
		Node list2Head = new Node();
		Node list2Tail = list2Head;

		Node p = list;

		while( null != p ){
			
			if( p.data < flag ){
				list1Tail = list1Tail.next = p;
			}
			else{
				list2Tail = list2Tail.next = p;
			}

			p = p.next;
		}

		list1Tail.next = list2Head.next;
		list2Tail.next = null;

		list = list1Head.next;
	}

	public static void main( String[] args ){

		int bar = 9;

		Node list = new Node();
		list.add(2).add(5).add(11).add(13).add(7).add(8).add(18).add(9).add(1);

		System.out.print("[Original]");
		list.print();

		partition( list, bar );
		
		System.out.print("[Modified]");
		list.print();

		System.out.println( "The partition bar is [" + bar + "]" );

		System.out.println( "----------------------------------------------" );

		bar = 2;

		System.out.print("[Original]");
		list.print();

		partition( list, bar );
		
		System.out.print("[Modified]");
		list.print();

		System.out.println( "The partition bar is [" + bar + "]" );

	
		list.clear();

		bar = 9;
		list.add(2).add(5).add(11).add(13).add(7).add(8).add(18).add(9).add(1);

		System.out.print("[Original]");
		list.print();

		partitionComp( list, bar );
		
		System.out.print("[Modified]");
		list.print();

		System.out.println( "The partition bar is [" + bar + "]" );

		System.out.println( "----------------------------------------------" );

		bar = 2;

		System.out.print("[Original]");
		list.print();

		partitionComp( list, bar );
		
		System.out.print("[Modified]");
		list.print();

		System.out.println( "The partition bar is [" + bar + "]" );
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

	Node( int i ){
		data = i;
		next = null;
		size = 1;
	}

	public Node add( int i ){

		Node p = this;
		while( null != p.next )
			p = p.next;

		p.next = new Node(i);
		
		return this;
	}

	public void clear(){
		this.next = null;
	}

	public void print(){

		System.out.print( "[List]: " );

		Node p = this;
		while( null != p.next ){
			System.out.print( p.data + "->" );
			p = p.next;
		}

		System.out.println( p.data );
	}
}
