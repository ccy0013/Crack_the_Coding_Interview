/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Tue Dec 15 14:33:46 2015
 ************************************************************************/

// Write a method to return all subsets of a set

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	private static void subSetsHelper(int[] set, int cur, ArrayList<Integer> subSet, ArrayList<ArrayList<Integer>> resultList) {
		if(cur==set.length) {
			resultList.add(subSet);
			return;
		}

		subSetsHelper(set, cur+1, subSet, resultList);

		ArrayList<Integer> temp = (ArrayList<Integer>)subSet.clone();
		temp.add(set[cur]);

		subSetsHelper(set, cur+1, temp, resultList);
	}

	public static ArrayList<ArrayList<Integer>> subSets(int[] set) {
		if(set==null || set.length==0)	return new ArrayList<ArrayList<Integer>>();

		ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();

		subSetsHelper(set, 0, new ArrayList<Integer>(), resultList);

		return resultList;
	}

	public static void main(String[] args) {
		int[] set = { 0, 1, 2, 3, 4, 5, 6};

		ArrayList<ArrayList<Integer>> subSets = subSets(set);

		System.out.println("[Set]: " + Arrays.toString(set));

		for(int i=0; i<subSets.size(); i++) {
			System.out.println(Arrays.toString(subSets.get(i).toArray()));
		}

		System.out.println(subSets.size() + " subsets in total.");
	}
}