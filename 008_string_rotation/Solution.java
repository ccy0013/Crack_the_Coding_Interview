/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Sat Jun 13 19:43:18 2015
 ************************************************************************/

public class Solution{

	public static boolean isRotation( String s1, String s2 ){

		if( s1.length() != s2.length() )
			return false;

		String str = s1 + s1;

		if( str.contains(s2) )
			return true;

		return false;
	}

	public static void main( String[] args ){

		String[] strings = { "a", "b", "ab", "ba", "aab", "bba", "ab", "b", "abacddfer", "dferabacd" };
		
		for( int i=0; i<strings.length-1; i+=2 ){

			System.out.println( "String" + i + ": " + strings[i] + "\n" + "String" + (i+1) + ": " + strings[i+1] );

			if( isRotation( strings[i], strings[i+1] ) )
				System.out.println( "String" + i + " is a rotation of String" + (i+1) );
			else
				System.out.println( "String" + i + " is not a rotation of String" + (i+1) );
		}

	}
}
