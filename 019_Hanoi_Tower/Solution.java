/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Fri Aug 14 16:18:44 2015
 ************************************************************************/

/* Solve the Hanoi problem by using stacks
 * i.e. Write a program to move the disks form the first tower to the last using stacks */

import java.util.Arrays;
import java.util.Stack;
import java.util.Comparator;

public class Solution{

	public static void  HanoiTower( Tower tower1, Tower tower2, Tower tower3, int numOfLayers ){


		if( numOfLayers == 1 ){
			tower3.push( tower1.pop() );
			
			printTowers( tower1, tower2, tower3 );
			return;
		}
		
		HanoiTower( tower1, tower3, tower2, numOfLayers-1 );
		Plate base = tower1.pop();
		tower3.push( base );
	
		printTowers( tower1, tower2, tower3 );
		
		HanoiTower( tower2, tower1, tower3, numOfLayers-1 );
	}

	public static void printTowers( Tower tower1, Tower tower2, Tower tower3 ){

		Tower[] towers = { tower1, tower2, tower3 };

		Comparator comp = new TowerComparator();
		Arrays.sort( towers, comp );
		
		for( int i=0; i<towers.length; i++ ){
			System.out.print( "[Tower " + towers[i].label + "]: " );
			towers[i].print();
		}
		System.out.println( "" );
	}

	public static void main( String[] args ){
		Tower[] towers = new Tower[3];
		
		for( int i=0; i<towers.length; i++ ){
			towers[i] = new Tower();
			towers[i].label = i;
		}
	
		towers[0].push( new Plate(4) );
		towers[0].push( new Plate(3) );
		towers[0].push( new Plate(2) );
		towers[0].push( new Plate(1) );

		System.out.println( "---------------------Original Towers--------------------" );
		for( int i=0; i<towers.length; i++ ){
			System.out.print( "[Tower " + i + "]: " );
			towers[i].print();
		}
		System.out.println( "--------------------------------------------------------" );

		HanoiTower( towers[0], towers[1], towers[2], towers[0].height );
	}

}

class Plate{

	public int size;

	Plate(){
		size = 1;
	}

	Plate( int s ){
		size = s;
	}

}

class Tower{

	public Stack<Plate> rod;
	public int height;
	public int label;

	Tower(){
		rod = new Stack<Plate>();
		height = 0;
		label = -1;
	}

	public boolean push( Plate p ){

		if( rod.empty() ){
			rod.push(p);
			height++;
			return true;
		}

		if( rod.peek().size >= p.size ){
			rod.push(p);
			height++;
			return true;
		}

		return false;
	}

	public Plate pop(){
		if( rod.empty() )
			return null;

		height--;
		return rod.pop();
	}

	public void print(){
		if( rod.empty() ){
			System.out.println( "empty" );
			return;
		}

		for( Plate p : rod ){
			System.out.print( p.size + " " );
		}
		System.out.println( "" );
	}
}

class TowerComparator implements Comparator{
	public int compare( Object o1, Object o2 ){
		Tower t1 = (Tower)o1;
		Tower t2 = (Tower)o2;

//		System.out.println("----");
		if( t1.label > t2.label )
			return 1;
		else if( t1.label == t2.label )
			return 0;
		else
			return -1;
	}
}
