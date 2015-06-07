/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Sun Jun  7 10:46:22 2015
 ************************************************************************/

public class Solution{

	public static String stringCompression( String s ){
		
		if( s.length() < 3 )	return s;

		char[] content = s.toCharArray();

		StringBuilder sb = new StringBuilder();

		int count=1, totalNum=0;
		int i=0,j=1;

		for( i=0; i<content.length; ){
			for( j=i+1; j<content.length; j++ ){

				if( content[i] == content[j] )
					count++;
				else{
					sb.append(content[i]).append(count);
					totalNum += count;
					count=1;
					i=j;
					break;
				}

			}

			if( j==content.length )
				break;
		}

		sb.append(content[i]).append(count);		

		return (sb.length()<s.length()) ? sb.toString() : s;
	}

	public static void main( String[] args ){

		String testStr1 = "a";
		System.out.println( stringCompression(testStr1) );

		String testStr2 = "abcdefg";	
		System.out.println( stringCompression(testStr2) );

		String testStr3 = "aabcccccaaa";
		System.out.println( stringCompression(testStr3) );
	}
}
