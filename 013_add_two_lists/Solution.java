/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Fri Jul  3 16:20:30 2015
 ************************************************************************/

/*You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.
 * FOLLOW UP *
 * Suppose the digits are stored in forward order. Repeat the above problem */


public class Solution{

	public static Node addLists( Node list1, Node list2 ){

		Node resultList = null;
		int carry = 0;

		Node p1 = list1, p2 = list2, p3 = resultList;

		while( null != p1 && null != p2 ){
			int temp = p1.data + p2.data + carry;

			if( temp > 9 ){
				temp -= 10;
				carry = 1;
			}
			else
				carry = 0;

			if( null == resultList )
				p3 = resultList = new Node( temp );
			else
				p3 = p3.next = new Node( temp );

			p1 = p1.next;
			p2 = p2.next;
		}

		while( null != p1 ){
			int temp = p1.data + carry;
			carry = 0;
			p3 = p3.next = new Node( temp );
			p1 = p1.next;
		}

		while( null != p2 ){
			int temp = p2.data + carry;
			carry = 0;
			p3 = p3.next = new Node( temp );
			p2 = p2.next;
		}

		return resultList;
	}

	public static Node addListsForward( Node list1, Node list2 ){

		Node resultList = new Node();
		int lastCarry = 0;

		if( list1.size == list2.size )
			addListsForwardHelper( list1, list2, resultList );
		else if( list1.size > list2.size ){
			Node newList2 = null;
			int diff = list1.size - list2.size;
			for( int i=0; i<diff; i++ ){
				Node n = new Node();
				n.next = list2;
				list2 = n;
			}
			lastCarry = addListsForwardHelper( list1, list2, resultList );
		}
		else{
			Node newList1 = null;
			int diff = list2.size - list1.size;
			for( int i=0; i<diff; i++ ){
				Node n = new Node();
				n.next = list1;
				list1 = n;
			}
			lastCarry = addListsForwardHelper( list1, list2, resultList );
		}

		if( 1 == lastCarry ){
			Node temp = new Node(1);
			temp.next = resultList;
			resultList = temp;
		}

		list1.print();
		list2.print();



		if( null == resultList )
			System.out.println(true);
		return resultList;
	}

	public static int addListsForwardHelper( Node list1, Node list2, Node result ){

		if( null==list1 && null==list2 ){
			return 0;
		}


		if( null == list1.next )
			result.next = null;
		else
			result.next = new Node();
		
		int carry = addListsForwardHelper( list1.next, list2.next, result.next );
		
		int temp = list1.data + list2.data + carry;

		if( temp > 9 ){
			temp -= 10;
			carry = 1;
		}
		else
			carry = 0;

		result.data = temp;
		//System.out.println(result.data);
	
		//result.print();
		
		return carry;
	}

	public static void main( String[] args ){

		/*TEST
		Node t = new Node(1);
		Node t_next = t.next;
		t_next = new Node();
		t_next.data = 1;
		System.out.println(t.next.data);
		*/


		Node list1 = new Node(7), list2 = new Node(5);
		list1.add(1).add(6);
		list2.add(9).add(2);
		System.out.print( "[Num1]" );
		list1.print();
		System.out.print( "[Num2]" );
		list2.print();

		Node result = addLists( list1, list2 );
		System.out.print( "[Result]" );
		result.print();
	
		System.out.println( "--------------------------------" );

		list1.add(5).add(6);
		list2.add(8);
		System.out.print( "[Num1]" );
		list1.print();
		System.out.print( "[Num2]" );
		list2.print();

		result = addLists( list1, list2 );
		System.out.print( "[Result]" );
		result.print();

		System.out.println( "-------------addForward---------------" );
		
		System.out.print( "[Num1]" );
		list1.print();
		System.out.print( "[Num2]" );
		list2.print();
		
		result = addListsForward( list1, list2 );
		
		System.out.print( "[Result]" );
		result.print();
		
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

	Node( int num ){
		data = num;
		next = null;
		size = 1;
	}

	public Node add( int num ){
		Node p = this;
		
		while( null != p.next ){
			p = p.next;
		}

		p.next = new Node(num);
		++size;

		return this;
	}

	public void print(){
		System.out.print( "[List]: " );

		Node p = this;
		while( null !=  p.next ){
			System.out.print( p.data + "->" );
			p = p.next;
		}

		System.out.println( p.data );
	}
}
