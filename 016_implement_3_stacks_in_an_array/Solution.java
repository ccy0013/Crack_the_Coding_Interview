/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Tue Aug 11 14:53:42 2015
 ************************************************************************/

/* Implement 3 stacks in an array */

public class Solution{

	public static int[] m_array;
	public static int[] m_tops;
	public static int m_stackSize;

	Solution(){
		m_array = null;
		m_tops = null;
		m_stackSize = 0;
	}

	public static void initFixedStacks( int size ){

		m_stackSize = size;

		m_array = new int [3*size];

		m_tops = new int [3];
		m_tops[0] = -1;
		m_tops[1] = m_stackSize-1;
		m_tops[2] = 2 * m_stackSize - 1;
	}

	public static void push( int stackNum, int value ){

		//Full stack exception
		if( m_tops[stackNum] + 1 >= (stackNum+1) * m_stackSize )
			return;

		m_array[++m_tops[stackNum]] = value;
	}

	public static int pop( int stackNum ){
		return m_array[m_tops[stackNum]--];
	}




	public static void main( String[] args ){
		initFixedStacks( 100 );

		push( 0, 1 );
		push( 0, 2 );

		push( 1, 9 );
		push( 1, 5 );

		push( 2, 3 );
		push( 2, 4 );

		System.out.print( "[Stack 0]: " );
		for( int i=0; i<=m_tops[0]; i++ ){
			System.out.print( m_array[i] );
		}
		System.out.println( "" );

		System.out.print( "[Stack 1]: " );
		for( int i=m_stackSize; i<=m_tops[1]; i++ ){
			System.out.print( m_array[i] );
		}
		System.out.println( "" );

		System.out.print( "[Stack 2]: " );
		for( int i=2*m_stackSize; i<=m_tops[2]; i++ ){
			System.out.print( m_array[i] );
		}
		System.out.println( "" );

		pop( 0 );
		pop( 1 );
		pop( 2 );

		System.out.print( "[Stack 0]: " );
		for( int i=0; i<=m_tops[0]; i++ ){
			System.out.print( m_array[i] );
		}
		System.out.println( "" );

		System.out.print( "[Stack 1]: " );
		for( int i=m_stackSize; i<=m_tops[1]; i++ ){
			System.out.print( m_array[i] );
		}
		System.out.println( "" );

		System.out.print( "[Stack 2]: " );
		for( int i=2*m_stackSize; i<=m_tops[2]; i++ ){
			System.out.print( m_array[i] );
		}
		System.out.println( "" );
	}

}


