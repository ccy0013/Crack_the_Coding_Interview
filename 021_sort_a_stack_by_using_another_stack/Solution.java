/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Sat Aug 15 22:51:35 2015
 ************************************************************************/

/* Write a program to sort a stack in ascending order (with biggest items
 * on top). You may use at most one additional stack to hold items, but you
 * may not copy the elements into any other data structure (such as an array).
 * The stack supports the following operations: push, pop, peek, and isEmpty.
 */

import java.util.Stack;
import java.util.Arrays;

public class Solution{

	public static void sortStack( Stack<Integer> s ){
		Stack<Integer> buffer = new Stack<Integer>();

		while( !s.empty() )
			buffer.push( s.pop() );

		while( !buffer.empty() )
			insertElement( s, buffer, buffer.pop() );
	}

	public static void insertElement( Stack<Integer> s, Stack<Integer> buffer, int e ){

		if( s.empty() ){
			s.push( e );
			return;
		}

		int counter = 0;
		while( !s.empty() && s.peek().intValue() < e ){
			buffer.push( s.pop() );
			counter++;
		}

		s.push( e );

		while( counter > 0 ){
			s.push( buffer.pop() );
			counter--;
		}
	}

	public static void main( String[] args ){

		Stack<Integer> s = new Stack<Integer>();

		s.push( 5 );
		s.push( 7 );
		s.push( 1 );
		s.push( -5 );
		s.push( 6 );
		s.push( 10 );
		s.push( 0 );

		System.out.println( "" );
		
		System.out.print( "[Before Sorting]: " );
		System.out.println( Arrays.toString(s.toArray()) );

		sortStack( s );

		System.out.print( "[After Sorting]: " );
		System.out.println( Arrays.toString(s.toArray()) );	

		System.out.println( "" );
	}
}
