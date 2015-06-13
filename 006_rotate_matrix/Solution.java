/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Tue Jun  9 22:18:05 2015
 ************************************************************************/

public class Solution{

	//For N*N image
	
	//Method 1: Single-pass solution with O(N^2) space
	public static Pixel[][] rotateMatrix( Pixel[][] matrix ){

		int size = matrix.length;

		Pixel[][] copy = new Pixel[size][size];

		for( int i=size-1; i>=0; i-- )
			for( int j=0; j<size; j++ ){
				copy[j][size-i-1] = matrix[i][j];
			}

		return copy;
	}

	//Method 2: Two-pass solution with O(1) space
	public static void rotateMatrix2( Pixel[][] matrix ){
		Pixel temp = new Pixel();
		for( int i=0; i<matrix.length; i++ ){
			for( int j=0; j<matrix.length-i; j++ ){
				temp = matrix[i][j];
				matrix[i][j] = matrix[matrix.length-1-j][matrix.length-1-i];
				matrix[matrix.length-1-j][matrix.length-1-i] = temp;
			}
		}

		for( int i=0; i<matrix.length/2; i++ ){
			for( int j=0; j<matrix.length; j++ ){
				temp = matrix[i][j];
				matrix[i][j] = matrix[matrix.length-1-i][j];
				matrix[matrix.length-1-i][j] = temp;
			}
		}
	}

	//Method 3: Single-pass solution with O(1) space
	public static void rotateMatrix3( Pixel[][] matrix ){
		Pixel temp = new Pixel();

		int size = matrix.length;

		for( int layer=0; layer<size/2; layer++ ){
			for( int j=layer; j<size-layer-1; j++ ){
				temp = matrix[j][size-layer-1];

				matrix[j][size-layer-1] = matrix[layer][j];
				matrix[layer][j] = matrix[size-j-1][layer];
				matrix[size-j-1][layer] = matrix[size-layer-1][size-j-1];
				matrix[size-layer-1][size-j-1] = temp;
			}
		}
	}

	public static void main( String[] args ){

		int size = 5;
		Pixel[][] matrix = new Pixel[size][size];


		for( int i=0; i<matrix.length; i++ ){
			for( int j=0; j<matrix[0].length; j++ ){
				matrix[i][j] = new Pixel(Integer.toString(i).charAt(0), Integer.toString(j).charAt(0), '0', '0' );
			}
		}

		Pixel[][] result = new Pixel[size][size];

		result = rotateMatrix( matrix );

		System.out.println( "[Original Matrix]");
		for( int i=0; i<matrix.length; i++ ){
			for( int j=0; j<matrix[0].length; j++ ){
				System.out.print( Character.toString(matrix[i][j].red) + Character.toString(matrix[i][j].green) + " " );
			
				if( j==matrix[0].length-1 )
					System.out.println( ' ' );
			}
		}

		System.out.println( "" );
		System.out.println( "[Matrix Rotated by Method 1]");
		
		for( int i=0; i<result.length; i++ ){
			for( int j=0; j<result[0].length; j++ ){
				System.out.print( Character.toString(result[i][j].red) + Character.toString(result[i][j].green) + " " );
			
				if( j==result[0].length-1 )
					System.out.println( ' ' );
			}
		}
		
		rotateMatrix2( matrix );
		
		System.out.println( "" );
		System.out.println( "[Matrix Rotated by Method 2]");

		for( int i=0; i<matrix.length; i++ ){
			for( int j=0; j<matrix[0].length; j++ ){
				System.out.print( Character.toString(matrix[i][j].red) + Character.toString(matrix[i][j].green) + " " );
			
				if( j==matrix[0].length-1 )
					System.out.println( ' ' );
			}
		}

		System.out.println( "" );
		
		for( int i=0; i<matrix.length; i++ ){
			for( int j=0; j<matrix[0].length; j++ ){
				matrix[i][j] = new Pixel(Integer.toString(i).charAt(0), Integer.toString(j).charAt(0), '0', '0' );
			}
		}

		rotateMatrix3( matrix );
		
		System.out.println( "" );
		System.out.println( "[Matrix Rotated by Method 3]");

		for( int i=0; i<matrix.length; i++ ){
			for( int j=0; j<matrix[0].length; j++ ){
				System.out.print( Character.toString(matrix[i][j].red) + Character.toString(matrix[i][j].green) + " " );
			
				if( j==matrix[0].length-1 )
					System.out.println( ' ' );
			}
		}

		System.out.println( "" );
	}
}
	
class Pixel{
		public char red;
		public char green;
		public char blue;
		public char alpha;

		Pixel(){
			red = '0';
			green = '0';
			blue = '0';
			alpha = '0';
		}

		Pixel( char r, char g, char b, char a ){
			red = r;
			green = g;
			blue = b;
			alpha = a;
		}

		Pixel( Pixel p ){
			red = p.red;
			green = p.green;
			blue = p.blue;
			alpha = p.alpha;
		}

		public void setPixel( char r, char g, char b, char a ){
			red = r;
			green = g;
			blue = b;
			alpha = a;
		}
	}
