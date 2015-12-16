/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Tue Dec 15 16:14:33 2015
 ************************************************************************/

/* Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents) and pennies (1 cent), write 
 * code to calculate the number of ways of representing n cents.
 */

public class Solution {
	private static int numOfWaysHelper(int cents, int cur, int curCoin, int[] coins) {
		if(cur==cents)
			return 1;
		else if(cur>cents)
			return 0;
		else {
			int temp = 0;

			for(int i=curCoin; i<coins.length; i++) {
				temp += numOfWaysHelper(cents, cur+coins[i], i, coins);
			}

			return temp;
		}
	}

	public static int numOfWays(int cents) {
		if(cents<=0)	return 0;

		int[] coins = {1, 5, 10, 25};

		return numOfWaysHelper(cents, 0, 0, coins);
	}

	public static void main(String[] args) {
		System.out.println("[26 cents]: " + numOfWays(26));
		System.out.println("[10 cents]: " + numOfWays(10));
	}
}