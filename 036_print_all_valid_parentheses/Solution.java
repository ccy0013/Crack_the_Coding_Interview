/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Tue Dec 15 15:07:27 2015
 ************************************************************************/

/* Implement an algorithm to print all valid (e.g. properly opened and closed) combinations of n-pairs of parentheses.
 
 * EXAMPLE
 * Input: 3
 * Output: ((())), (()()), (())(), ()(()), ()()()
 */

import java.util.ArrayList;

public class Solution {
	private static void validCombinationsHelper(int n, int cur, int stack, String curCombination, ArrayList<String> resultList) {
		if(cur==n) {
			for(int i=0; i<stack; i++) {
				curCombination += ')';
			}
			resultList.add(curCombination);
			return;
		}

		validCombinationsHelper(n, cur+1, stack+1, curCombination+'(', resultList);

		for(int i=0; i<stack; i++) {
			validCombinationsHelper(n, cur, --stack, curCombination+')', resultList);
		}
	}

	public static ArrayList<String> validCombinations(int n) {
		ArrayList<String> resultList = new ArrayList<String>();

		if(n<=0)	return resultList;

		validCombinationsHelper(n, 0, 0, "", resultList);

		return resultList;
	}

	public static void main(String[] args) {
		System.out.println("[n=2]: ");
		ArrayList<String> resultList = validCombinations(2);

		for(int i=0; i<resultList.size(); i++) {
			System.out.println(resultList.get(i));
		}

		System.out.println("[n=3]: ");
		resultList = validCombinations(3);

		for(int i=0; i<resultList.size(); i++) {
			System.out.println(resultList.get(i));
		}
	}
}
