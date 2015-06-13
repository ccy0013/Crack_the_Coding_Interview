/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Fri Jun 12 23:14:31 2015
 ************************************************************************/

import java.util.*;

public class Solution{

	public static void modifyMatrix( int[][] matrix ){
		
		int width = matrix.length;
		int length = matrix[0].length;

		Set<Integer>rowTable = new HashSet<Integer>();
		Set<Integer> colTable = new HashSet<Integer>();

		for( int i=0; i<width; i++ ){
			for( int j=0; j<length; j++ ){
				if( 0 == matrix[i][j] )
				{
					rowTable.add( i );
					colTable.add( j );
				}
			}
		}

	//	System.out.println( rowTable.size() );
	//	System.out.println( colTable.size() );

		for( Integer row : rowTable ){
			for( int j=0; j<length; j++ ){
				matrix[row.intValue()][j] = 0;
			}
		}

		for( Integer col : colTable ){
			for( int i=0; i<width; i++ ){
				matrix[i][col.intValue()] = 0;
			}
		}
	}

	public static void main( String[] args ){

		int[][] matrix = new int[4][5];

		for( int i=0; i<4; i++ ){
			for( int j=0; j<5; j++ ){
				matrix[i][j] = ( 0== (i+j)%6 ) ? 0 : (new Random(i+j).nextInt())%100;

				System.out.print( matrix[i][j] + " " );
				
				if( j==4 )
					System.out.println( " " );
			}
		}

		modifyMatrix( matrix );

		for( int i=0; i<4; i++ ){
			for( int j=0; j<5; j++ ){
				System.out.print( matrix[i][j] + " " );

				if( j== 4 )
					System.out.println( " " );
			}
		}
	}
}
