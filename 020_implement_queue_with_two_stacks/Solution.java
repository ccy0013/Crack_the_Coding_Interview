/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Sat Aug 15 22:10:43 2015
 ************************************************************************/

/* Implement a MyQueue class which implements a queue using two stacks */

import java.util.Stack;

public class Solution{

	public static void main( String[] args ){
		
		MyQueue queue = new MyQueue();

		for( int i=0; i<5; i++ )
			queue.enQueue( i );

		queue.print();

		System.out.println( "DeQueue 2 elements: " );
		for( int i=0; i<2; i++ )
			System.out.print( queue.deQueue() + " " );
		System.out.println( "" );

		for( int i=0; i<5; i++ )
			queue.enQueue( i+15 );
		
		queue.print();

		System.out.println( "DeQueue 5 elements: " );
		for( int i=0; i<5; i++ )
			System.out.print( queue.deQueue() + " " );
		System.out.println( "" );

		System.out.println( "Elements left in the queue: " );
		queue.print();
	}

}

class MyQueue{

	private Stack<Integer> stack_in;
	private Stack<Integer> stack_out;

	MyQueue(){
		stack_in = new Stack<Integer>();
		stack_out = new Stack<Integer>();
	}

	public void enQueue( int data ){
		stack_in.push( data );
	}

	public int deQueue(){
		
		int result = 0;

		if( !stack_out.empty() )
			result = stack_out.pop();
		else{
			if( stack_in.empty() ){
				System.out.println( "Error - empty queue" );
				return result;
			}

			while( !stack_in.empty() ){
				stack_out.push( stack_in.pop() );
			}

			result = stack_out.pop();
		}

		return result;
	}

	public void print(){
		
		System.out.println( "---------------------------------------" );
		System.out.print( "Elements in stack_in: " );
		
		if( stack_in.empty() )
			System.out.println( "Empty" );
		else{
			for( Integer i : stack_in )
				System.out.print( i + " " );

			System.out.println( "" );
		}
		
		System.out.print( "Elements in stack_out: " );
		
		if( stack_out.empty() )
			System.out.println( "Empty" );
		else{
			for( Integer i : stack_out )
				System.out.print( i + " " );

			System.out.println( "" );
	
		}
		System.out.println( "---------------------------------------" );
	}
}
				
