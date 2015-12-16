/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Tue Dec 15 14:09:38 2015
 ************************************************************************/

/* A magic index in an array A[0...n-1] is defined to be an index such that
 * A[i] = i. Given a sorted array of distinct integers, write a method to 
 * find a magic index, if one exists, in array A.

 * FOLLOW UP *
 * What if the values are not distinct?
 */

import java.util.Arrays;

public class Solution {

	private static int findMagicIndexHelper(int[] nums, int start, int end) {
		if(start==end)	return nums[start]==start ? start : -1;

		int mid = (start+end)/2;

		if(nums[mid]==mid)
			return mid;
		else if(nums[mid] > mid)
			return findMagicIndexHelper(nums, start, mid);
		else
			return findMagicIndexHelper(nums, mid+1, end);
	}

	// O(log(n)) solution for distinct values
	// For follow-up, scan the whole array in order, so it's a simple O(n) solution
	// Return value
	// The magic index if exists, otherwise returns -1
	public static int findMagicIndex(int[] nums) {
		if(nums==null || nums.length==0)
			return -1;

		return findMagicIndexHelper(nums, 0, nums.length-1);
	}

	public static void main(String[] args) {
		int[] array1 = { 0, 2, 3, 5, 8, 10};
		int[] array2 = { -1, 0, 1, 3};
		int[] array3 = { -10, -5, -1, 2, 4, 5};
		int[] array4 = { 1, 3, 4, 6, 8, 10};

		System.out.println("[Array]: " + Arrays.toString(array1));
		System.out.println("[Magic Index]: " + findMagicIndex(array1));

		System.out.println("[Array]: " + Arrays.toString(array2));
		System.out.println("[Magic Index]: " + findMagicIndex(array2));

		System.out.println("[Array]: " + Arrays.toString(array3));
		System.out.println("[Magic Index]: " + findMagicIndex(array3));

		System.out.println("[Array]: " + Arrays.toString(array4));
		System.out.println("[Magic Index]: " + findMagicIndex(array4));
	}
}