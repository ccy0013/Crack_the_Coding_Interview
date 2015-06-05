/*************************************************************************
    > File Name: MyHashTable.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Tue Jun  2 21:17:41 2015
 ************************************************************************/

public class MyHashTable{

	public class Entry{
		private String m_key;
		private String m_value;

		Entry(){
			m_key = "";
			m_value = "";
		}

		Entry( String k, String v ){
			m_key = k;
			m_value = v;
		}

		Entry( Entry e ){
			m_key = e.m_key;
			m_value = e.m_value;
		}

		public String getKey(){
			return m_key;
		}

		public String getValue(){
			return m_value;
		}

		public void set( String k, String v ){
			m_key = k;
			m_value = v;
		}
	}

	private int m_size;
	private Entry[] m_table;
	private int m_capacity;

	MyHashTable(){
		m_capacity = 16;
		m_size = 0;
		m_table = new Entry[m_capacity];
	}
			
	MyHashTable( int c ) {
		m_capacity = c;
		m_size = 0;
		m_table = new Entry[m_capacity];
	}

	public String put( String key, String value ){
		int hashCode = key.hashCode();

		int pos = hashCode % m_capacity;

		Entry entry = new Entry( key, value );

		while( true ){
			if( null == m_table[pos] || m_table[pos].getKey().equals(key) ){
				m_table[pos] = entry;
				break;
			}
			else{
				pos++;

				if( pos == m_capacity )
					pos = 0;
			}
		}

		m_size++;

		if( m_size/(float)m_capacity > 0.75f ){
		/*	
			System.out.println("-----------");
		
			for( int i=0; i<m_capacity; i++ )
				if( m_table[i] != null )
					System.out.println( m_table[i].getKey() + " " + m_table[i].getValue() );
			
			System.out.println("-----------");
		*/
			Entry[] copy = new Entry[m_capacity];

			for( int i=0; i<m_capacity; i++ ){
				copy[i] = m_table[i];
			}

			m_capacity *= 2;
			m_size = 0;
			m_table = new Entry[m_capacity];

			for( int i=0; i<copy.length; i++ ){
				if( null != copy[i] )
					put( copy[i].getKey(), copy[i].getValue() );
			}
		}

		return value;
	}

	public String get( String key ){
		int hashCode = key.hashCode();
		int pos = hashCode % m_capacity;

		while( true ){
			if( null == m_table[pos] )
				return "";
			else if( m_table[pos].getKey().equals(key) )
				return m_table[pos].getValue();
			else{
				pos++;
				if( pos == m_capacity )
					pos = 0;
			}
		}
	}

	public int capacity(){
		return m_capacity;
	}

	public int size(){
		return m_size;
	}

	public static void main ( String[] args ) {

		MyHashTable myTable = new MyHashTable();
		
		System.out.println( "[Original] SIZE / CAPACITY" );
		System.out.println( myTable.size() + " / " + myTable.capacity());

		
		//MyHashTable myTable2 = new MyHashTable(20);
		//System.out.println(Integer.toString(myTable2.size()));

		for( int i=0; i<32; i++ ){
			myTable.put( Integer.toString(i), "Element "+i );
		}

		for( int i=0; i<32; i++ ){
			System.out.println( myTable.get( Integer.toString(i) ));
		}

		System.out.println( "[Current] SIZE / CAPACITY" );
		System.out.println( myTable.size() + "/" + myTable.capacity() );
	}
}
