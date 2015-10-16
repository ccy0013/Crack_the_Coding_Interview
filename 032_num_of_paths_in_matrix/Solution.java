/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Thu Oct 15 19:49:14 2015
 ************************************************************************/

/* Imagine a robot sitting on the upper left corner of an X by Y grid. The
   robot can only move in two directions: right and down. How many possible 
   paths are there for the robot to go from (0, 0) to (X, Y)?
*/

public class Solution {

	public static int numOfPaths( int x, int y ) {
		if(x==0 || y==0)	return (x==0&&y==0) ? 0 : 1;

		int[][] result = new int[x][y];

		for( int i=0; i<x; i++ ) {
			for( int j=0; j<y; j++ ) {
				if(i==0 || j==0) {
					result[i][j] = 1;
					continue;
				}

				result[i][j] = result[i-1][j] + result[i][j-1];
			}
		}

		return result[x-1][y-1];
	}

	public static void main(String[] args) {
		for( int i=0; i<10; i++ ) {
			for( int j=0; j<10; j++ ) {
				System.out.println("(" + i + ", " + j + "): " + numOfPaths(i, j)); 
			}
		}
	}
}
