/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Wed Aug 12 13:35:29 2015
 ************************************************************************/

/* How would you design a stack which, in addition to push and pop, also 
 * has a function min which returns the minimum element? Push, pop and min 
 * should all operate in O(1) time. */

import java.util.Stack;

public class Solution{

	public static void main( String[] args ){

		StackWithMin s = new StackWithMin();

		s.push(5);
		System.out.println( "After pushing 5, the min of the stack is: " + s.min() );

		s.push(6);
		System.out.println( "After pushing 6, the min of the stack is: " + s.min() );
		
		s.push(3);
		System.out.println( "After pushing 3, the min of the stack is: " + s.min() );
		
		s.push(7);
		System.out.println( "After pushing 7, the min of the stack is: " + s.min() );
		
		s.pop();
		System.out.println( "After pop, the min of the stack is: " + s.min() );
		
		s.pop();
		System.out.println( "After pop, the min of the stack is: " + s.min() );

	}

}

class StackWithMin extends Stack<NodeWithMin> {

	public void push( int value ){
		super.push( new NodeWithMin( value, Math.min(value, min()) ) );
	}

	public int min(){
		if( this.empty() )
			return Integer.MAX_VALUE;
		else
			return peek().curMin;
	}

}

class NodeWithMin{

	int value;
	int curMin;

	NodeWithMin(){
		value = 0;
		curMin = 0;
	}

	NodeWithMin( int v, int m ){
		value = v;
		curMin = m;
	}

}

