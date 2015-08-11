/************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Fri Aug  7 08:53:45 2015
 ************************************************************************/

import java.util.Stack;

public class Solution{

	public static boolean isPalindrome( Node list ){

		Stack<Character> s = new Stack<Character>();

		Node temp = list;

		while( null != temp ){
			s.push( temp.data );
			temp = temp.next;
		}

		return checkHelper( list, s );
	}

	public static boolean checkHelper( Node list, Stack<Character> s ){
		/*
		if( null==list )
			return true;

		if( !checkHelper( list.next, s ) )
			return false;


		if( s.peek().equals(new Character(list.data)) ){
			Character top = s.pop();

			System.out.println( top );
			
			if( s.empty() )
				return true;
		}
		else
			return false;
		
		return true;
		*/

		Node temp = list;
		
		while( null != temp ){
			if( temp.data == s.peek().charValue() )
				s.pop();
			else
				return false;

			temp = temp.next;
		}

		if( s.empty() )
			return true;
		else
			return false;
	}

	public static void main( String[] args ){

		Node list = new Node('c');
		list.add('a').add('d').add('b').add('d').add('a').add('c');

		list.print();

		System.out.println( isPalindrome(list) );
	
		Node list2 = new Node('c');
		list2.add('e').add('d').add('b').add('d').add('a').add('c');

		list2.print();

		System.out.println( isPalindrome(list2) );
		
	}

}

class Node{

	public char data;
	public Node next;

	public int size;

	Node(){
		data = ' ';
		next = null;
		size = 1;
	}

	Node( char c ){
		data = c;
		next = null;
		size = 1;
	}

	public Node add( char c ){

		Node temp = this;

		while( null != temp.next )
			temp = temp.next;

		temp.next = new Node(c);

		size++;

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
