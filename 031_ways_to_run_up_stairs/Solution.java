/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Thu Oct 15 19:22:00 2015
 ************************************************************************/

/* A child is running up a staircase with n steps, and can hop either 1 step, 
   2 steps, or 3 steps at a time. Implement a method to count how many possible 
   ways the child can run up the stairs.
*/

public class Solution {

	public static int countWays( int n ) {
		if(n==1)	return 1;
		if(n==2)	return 2;
		if(n==3)	return 4;

		int[] result = new int[n];

		result[0] = 1;
		result[1] = 2;
		result[2] = 4;

		for( int i=3; i<n; i++ ) {
			result[i] = result[i-3] + result[i-2] + result[i-1];
		}

		return result[n-1];
	}

	public static void main(String[] args) {
		for( int i=1; i<=10; i++ ) {
			System.out.println( "[" + i + "]" + countWays(i));
		}
	}
}
