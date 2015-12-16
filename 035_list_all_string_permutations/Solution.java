/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Tue Dec 15 14:49:52 2015
 ************************************************************************/

// Wirte a method to compute all permutations of a string of unique characters

import java.util.ArrayList;

public class Solution {
	private static void listPermutationsHelper(String str, String curPermutation, ArrayList<String> permutationList) {
		if(str.length()==0) {
			permutationList.add(curPermutation);
			return;
		}

		for(int i=0; i<str.length(); i++) {
			listPermutationsHelper(str.substring(0, i)+str.substring(i+1), curPermutation+str.charAt(i), permutationList);
		}
	}

	public static ArrayList<String> listPermutations(String str) {
		if(str==null || str.length()==0)	return new ArrayList<String>();

		ArrayList<String> permutationList = new ArrayList<String>();

		listPermutationsHelper(str, "", permutationList);

		return permutationList;
	}

	public static void main(String[] args) {
		String str = "KatrinA";

		ArrayList<String> permutationList = listPermutations(str);

		System.out.println("[String]: " + str);

		for(int i=0; i<permutationList.size(); i++) {
			System.out.println(permutationList.get(i));
		}

		System.out.println(permutationList.size() + " permutations in total.");
	}
}
