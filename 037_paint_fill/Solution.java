/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Tue Dec 15 15:44:03 2015
 ************************************************************************/

/* Implement the "paint fill" function that one might see on many image editing programs. That is, given a screen 
 * (represented by a two-dimensional array of colors), a point, and a new color, fill in the surrounding area until 
 * the color changes from the original color.
 */

import java.util.Arrays;

public class Solution {
	public static void paintFillHelper(Color3[][] screen, int x, int y, Color3 originalColor, Color3 newColor) {
		if(x<0 || x>=screen.length || y<0 || y>=screen[0].length || !screen[x][y].equalsTo(originalColor))	return;

		screen[x][y].r = newColor.r;
		screen[x][y].g = newColor.g;
		screen[x][y].b = newColor.b;

		paintFillHelper(screen, x+1, y, originalColor, newColor);
		paintFillHelper(screen, x-1, y, originalColor, newColor);
		paintFillHelper(screen, x, y+1, originalColor, newColor);
		paintFillHelper(screen, x, y-1, originalColor, newColor);
	}

	public static void paintFill(Color3[][] screen, int x, int y, Color3 newColor) {
		if(x<0 || x>=screen.length || y<0 || y>=screen[0].length)	return;

		paintFillHelper(screen, x, y, new Color3(screen[x][y]), newColor);
	}

	public static void main(String[] args) {
		Color3[][] screen = new Color3[5][5];

		for(int i=0; i<screen.length; i++) {
			for(int j=0; j<screen[0].length; j++) {
				screen[i][j] = new Color3();
			}
		}

		short x = 1;
		screen[1][1].set(x, x, x);
		screen[1][2].set(x, x, x);
		screen[2][2].set(x, x, x);
		screen[2][3].set(x, x, x);
		screen[3][2].set(x, x, x);

		System.out.println("[Original Screen]: ");
		for(int i=0; i<screen.length; i++) {
			for(int j=0; j<screen[0].length; j++) {
				System.out.print( (screen[i][j].r+screen[i][j].g+screen[i][j].b) + " ");
			}
			System.out.println("");
		}

		paintFill(screen, 1, 1, new Color3((short)3, (short)3, (short)3));

		System.out.println("[Screen After Paint]: ");
		for(int i=0; i<screen.length; i++) {
			for(int j=0; j<screen[0].length; j++) {
				System.out.print( (screen[i][j].r+screen[i][j].g+screen[i][j].b) + " ");
			}
			System.out.println("");
		}
	}
}

class Color3 {
	public short r;
	public short g;
	public short b;

	public Color3() {
		r = g = b;
	}

	public Color3(short r, short g, short b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}

	public Color3(Color3 c) {
		this.r = c.r;
		this.g = c.g;
		this.b = c.b;
	}

	public boolean equalsTo(Color3 c) {
		return this.r==c.r && this.g==c.g && this.b==c.b;
	}

	public void set(short r, short g, short b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
}
