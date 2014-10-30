/*************************************************************************
    > File Name: MySolution.java
    > Author: ma6174
    > Mail: ma6174@163.com 
    > Created Time: Wed Oct 29 22:46:00 2014
 ************************************************************************/
public class MySolution {
	public static void main( String[] args ) {
		String[] strTest = new String[10];

		strTest[0] = "";
		strTest[1] = "a";
		strTest[2] = "aa";
		strTest[3] = "aaa";
		strTest[4] = "aabbcc";
		strTest[5] = "a    b";
		strTest[6] = "a    a";
		strTest[7] = " a b c ";
		strTest[8] = "aaaaa     bbbbbbbbbbb";
		strTest[9] = "asdfkasdfkiiiissew";

		for( String s: strTest ) {
			System.out.println( "Before de-dup:|" + s + "|");
			System.out.println( "After  de-dup:|" + removeDuplicateChars(s) + "|");
		}
	}

	public static String removeDuplicateChars( String str ) {
		if( str.equals("") )	return str;

		char[] chars = str.toCharArray();

		int i=0, dup = chars.length-1;
		while( i<dup ) {
			int j=dup;
			for( ; j>i; j-- ) {
				if(chars[i]==chars[j]) {
					chars[j] = chars[dup];
					dup--;
				}
			}
			if( j==i ){
				i++;
			}
		}

		str = new String(chars, 0, dup+1);
		return str;
	}
}
