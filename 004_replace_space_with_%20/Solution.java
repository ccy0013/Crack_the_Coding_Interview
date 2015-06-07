/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Sun Jun  7 10:05:26 2015
 ************************************************************************/

public class Solution{

	public static  String spaceReplacement( String s, int len ){

		char[] content = s.substring(0, len).toCharArray();

		StringBuilder sb = new StringBuilder();
		for (char c : content) {
			if( ' ' == c ){
				sb.append("%20");
			}
			else
				sb.append(c);
		}

		return sb.toString();
	}

	public static void main( String[] args ){
		
		String testString1 = "1 2 3 4 5 6 7 8 9";
		System.out.println(spaceReplacement(testString1, 10));


		String testString2 = "  abc de f   ";
		System.out.println(spaceReplacement(testString2, 13));
	}
}
