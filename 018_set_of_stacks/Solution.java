/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Wed Aug 12 15:02:14 2015
 ************************************************************************/

/* Imagine a (literal) stack of plates. If the stack gets too high, it might
 * topple. Therefore, in real life, we would likely start a new stack when
 * the previous stak exceeds some threshold. Implement a data structure
 * SetOfStacks that mimics this. SetOfStacks should be composed of several
 * stacks and should create a new stack once the previous one exceeds capacity.
 * SetOfStacks.push() and SetOfStacks.pop() should behae identically to a
 * single stack.
 *							FOLLOW UP
 * Implement a function popAt(int index) which performs a pop operation on a
 * specific sub-stack.
 */

import java.util.LinkedList;
import java.util.Stack;
import java.util.Arrays;

public class Solution{

	public static void main( String[] args ){
		SetOfStacks s = new SetOfStacks();

		s.setCapacity( 3 );

		for( int i=0; i<10; i++ )
			s.push(i);

		System.out.println( "First push 0-9 onto the set of stacks, each of which has a capacity of 3" );
		for( int i=0; i<=s.curStackNo; i++ ){
			System.out.print( "[Stack " + i + "]: " );
			System.out.println( Arrays.toString( s.stacks.get(i).toArray() ) );
		}
		
		System.out.println( "Pop last two elements: " );
		s.pop();
		s.pop();
		for( int i=0; i<=s.curStackNo; i++ ){
			System.out.print( "[Stack " + i + "]: " );
			System.out.println( Arrays.toString( s.stacks.get(i).toArray() ) );
		}

		System.out.println( "Pop the last element in sub-stack 0: " );
		s.pop(0);
		for( int i=0; i<=s.curStackNo; i++ ){
			System.out.print( "[Stack " + i + "]: " );
			System.out.println( Arrays.toString( s.stacks.get(i).toArray() ) );
		}

		System.out.println( "Pop all elments in sub-stack 1: " );
		for( int i=0; i<s.m_capacity; i++ )
			s.pop(1);
		for( int i=0; i<=s.curStackNo; i++ ){
			System.out.print( "[Stack " + i + "]: " );
			System.out.println( Arrays.toString( s.stacks.get(i).toArray() ) );
		}

	}


}

class SetOfStacks{

	public LinkedList<Stack<Integer>> stacks;
	public int m_capacity;
	public int curStackNo;

	SetOfStacks(){
		stacks = new LinkedList<Stack<Integer>>();
		stacks.add( new Stack<Integer>() );
		m_capacity = 5;
		curStackNo = 0;
	}

	public void setCapacity( int c ){
		m_capacity = c;
	}

	public void push( int num ){

		if( stacks.get(curStackNo).size() < m_capacity )
			stacks.get(curStackNo).push( num );
		else{
			stacks.add( new Stack<Integer>() );
			stacks.get(++curStackNo).push( num );
		}
	}

	public int pop(){

		int result = stacks.get(curStackNo).pop();

		if( 0 == stacks.get(curStackNo).size() ){
			stacks.removeLast();
			--curStackNo;
		}

		return result;
	}

	public int pop( int stackNo ){
		
		int result = stacks.get(stackNo).pop();

		if( stacks.get(stackNo).empty() ){
			stacks.remove(stackNo);
			--curStackNo;
		}

		return result;
	}
	
}


