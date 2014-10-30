/*************************************************************************
    > File Name: MySolution.java
    > Author: ma6174
    > Mail: ma6174@163.com 
    > Created Time: Wed Oct 29 21:01:11 2014
 ************************************************************************/
public class MySolution {
	public static void main( String[] args) {
		String str1 = "asdfalkjwer";
		String str2 = "wertyuiopcvbnm,.";

		System.out.println("For string 1: "+str1+"\n"+isAllCharUnique(str1));
		System.out.println("For string 2: "+str2+"\n"+isAllCharUnique(str2));
	}


	public static boolean isAllCharUnique( String str ){
		boolean[] charset = new boolean[256];

		for( int i=0; i<str.length(); i++ ){
			int val = (int)str.charAt(i);
			if( charset[val] ) return false;
			else{
				charset[val] = true;
			}
		}
		return true;
	}
}
