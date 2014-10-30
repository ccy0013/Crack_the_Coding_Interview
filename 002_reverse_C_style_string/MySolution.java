/*************************************************************************
    > File Name: MySolution.java
    > Author: ma6174
    > Mail: ma6174@163.com 
    > Created Time: Wed Oct 29 21:29:27 2014
 ************************************************************************/
public class MySolution {
	public static void main( String[] args ) {
		String[] strTest = new String[8];

		strTest[0] = "";
		strTest[1] = " 12 34 ";
		strTest[2] = "aabbccddeeff ";
		strTest[3] = "a ";
		strTest[4] = "aabbcddee ";
		strTest[5] = "    abc  ";
		strTest[6] = "0123456789 ";
		strTest[7] = "0 1 3 6 9         3 ";
		
		for( String s : strTest ) {
			System.out.println( "Before reverse:  |" + s + "|");
			System.out.println( "After reverse:   |" + reverseString(s) + "|");
		}
	}

	public static String reverseString( String str ) {
		int posMid = (str.length()-1)/2;
		int len = str.length();

		char[] array = str.toCharArray();
		for( int i=0; i<posMid; i++ ){
			char temp = array[i];
			array[i] = array[len-2-i];
			array[len-2-i] = temp;
		}
		
		str = new String( array );
		return str;
	}
}
