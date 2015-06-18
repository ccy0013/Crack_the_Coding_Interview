/*************************************************************************
    > File Name: Node.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Wed Jun 17 10:30:08 2015
 ************************************************************************/

public class Node{

	int data;
	
	Node next;

	int size;

	Node(){
		size = 1;
		data = 0;
		next = null;
	}

	Node( int num ){
		size = 1;
		data = num;
		next = null;
	}

//	Node( Node n ){
//		this.size = n.size;
//		this.data = n.data;
//
//this.next = n.next;
//	}

	
	//Append a new node containg the required data to the end of list
	public Node append( int num ){
	
		Node temp = this;

		while( null != temp.next ){
			temp = temp.next;
		}

		temp.next = new Node(num);

		++size;

		return this;
	}

	//Remove first occurence of nodes that contains target data
	public Node remove( int num ){

		Node temp = this;

		if( num == temp.data ){
			--size;
			return this.next;
		}
	
		while( null != temp.next ){

			if( num == temp.next.data ){
				temp.next = temp.next.next;
				--size;
				return this;
			}

			temp = temp.next;
		}

		return this;
	}

	
	public static void main( String[] args ){

		Node list = new Node();

		list.append( 1 );
		list.append( 2 );
		list.append( 3 );
		list.append( 4 );
		
		Node p = list;

		System.out.print( "List: " );
		while( null != p ){
			if( null != p.next )
				System.out.print( p.data + " -> " );
			else
				System.out.println( p.data );
			
			p = p.next;
		}

		list = list.remove(0);
		p = list;

		System.out.println( "[After deleting 0]" );
		System.out.print( "List: " );
		while( null != p ){
			if( null != p.next )
				System.out.print( p.data + " -> " );
			else
				System.out.println( p.data );
			
			p = p.next;
		}

		list = list.remove( 2 );
		p = list;
		
		System.out.println( "[After deleting 2]" );
		System.out.print( "List: " );
		while( null != p ){
			if( null != p.next )
				System.out.print( p.data + " -> " );
			else
				System.out.println( p.data );
			
			p = p.next;
		}


		list = list.remove( 4 );
		p = list;

		System.out.println( "[After deleting 4]" );
		System.out.print( "List: " );
		while( null != p ){
			if( null != p.next )
				System.out.print( p.data + " -> " );
			else
				System.out.println( p.data );
			
			p = p.next;
		}

	}

}
