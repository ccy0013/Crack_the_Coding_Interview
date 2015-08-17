/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Sun Aug 16 19:22:22 2015
 ************************************************************************/

/* An animal shelter holds only dogs and cats, and operates on a strictly 
 * "first in, first out" basis. People must adopt either the "oldest" (based
 * on arrival time) of all animals at the shelter, or they can selct whether
 * they would prefer a dog or a cat (and will receive the oldest animal of
 * that type). They cannot select which specifix animal they would like.
 * 
 * Create the data structures to maintain this system and implement operations
 * such as enqueue, dequeueAny, dequeueDog and dequeueCat. You may use the
 * built-in LinkedList data structure.
 */

import java.util.LinkedList;

public class Solution{

	public static void main( String[] args ){

		/*
		Animal a = new Dog();

		if( a instanceof Dog )
			System.out.println( "a is a dog" );
		else if( a instanceof Cat )
			System.out.println( "a is a cat" );

		if( a instanceof Animal )
			System.out.println( "a is an animal" );

		System.out.println(a.getClass());
		*/

		AnimalShleter s = new AnimalShleter();

		s.enqueue( new Dog( "Jack" ) );
		s.enqueue( new Dog( "Pocky" ) );
		s.enqueue( new Cat( "April" ) );
		s.enqueue( new Dog( "Jimmy" ) );
		s.enqueue( new Cat( "Summer" ) );

		s.print();

		System.out.println( "After calling dequeueAny: " );
		s.dequeueAny();
		s.print();

		System.out.println( "After calling dequeueCat: " );
		s.dequeueCat();
		s.print();

		System.out.println( "After calling dequeueDog: " );
		s.dequeueDog();
		s.print();

	}
}

class AnimalShleter{
	
	public LinkedList<Animal> shleter;

	AnimalShleter(){
		shleter = new LinkedList<Animal>();
	}

	public void enqueue( Animal a ){
		shleter.add( a );
	}

	public Animal dequeueAny(){
		return shleter.remove(0);
	}

	public Dog dequeueDog(){
	
		for( int i=0; i<shleter.size(); i++ ){
			Animal temp = shleter.get(i);
			if( temp instanceof Dog ){
				shleter.remove(i);
				return (Dog)temp;
			}
		}
		
		return new Dog( "Error - No Dog Available" );
	}

	public Cat dequeueCat(){
		for( int i=0; i<shleter.size(); i++ ){
			Animal temp = shleter.get(i);
			if( temp instanceof Cat ){
				shleter.remove(i);
				return (Cat)temp;
			}
		}

		return new Cat( "Error - No Cat Available" );
	}

	public void print(){
		System.out.print( "[Shelter]: " );
		for( Animal a : shleter )
			System.out.print( "( " + a.getClass() + " - " + a.name + " ) " );
		System.out.println( "" );
	}
}

class Animal{
	int age;
	String name;

	Animal(){
		age = 1;
		name = "";
	}

	Animal( String n ){
		age = 1;
		name = n;
	}

	Animal( int i, String n ){
		age = i;
		name = n;
	}

	public void makeSounds(){
		System.out.println( "Animal" );
	}
}

class Dog extends Animal{
	
	Dog(){
		super();
	}

	Dog( String n ){
		super();
		name = n;
	}

	public void makeSounds(){
		System.out.println( "Dog - Bark" );
	}
}

class Cat extends Animal{

	Cat(){
		super();
	}

	Cat( String n ){
		super();
		name = n;
	}

	public void makeSounds(){
		System.out.println( "Cat - Meow" );
	}
}
