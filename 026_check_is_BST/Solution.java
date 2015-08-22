/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Thu Aug 20 16:07:38 2015
 ************************************************************************/

public class Solution{

	public static boolean isBST( BinaryTreeNode root ){
		return isBSTHelper( root, Integer.MIN_VALUE, Integer.MAX_VALUE );
	}

	private static boolean isBSTHelper( BinaryTreeNode root, Integer min, Integer max ){
		
		if( null == root )
			return true;

		if( null == root.left && null == root.right ){
			return true;
		}

		if( min.intValue() >= root.data || root.data > max.intValue() )
			return false;

		return isBSTHelper( root.left, min, root.data ) && isBSTHelper( root.right, root.data, max );
	}

	public static void main( String[] args ){
		
		BinaryTreeNode tree1 = new BinaryTreeNode();
		BinaryTreeNode[] nodes = new BinaryTreeNode[10];

		for( int i=0; i<nodes.length; i++ )
			nodes[i] = new BinaryTreeNode(i+1);

		tree1.left = nodes[0];
		tree1.right = nodes[1];

		for( int i=0; i<4; i++ ){
			nodes[i].left = nodes[2*i+2];
			nodes[i].right = nodes[2*i+3];
		}

		tree1.print();

		System.out.println( isBST(tree1) );

		
		BinaryTreeNode tree2 = new BinaryTreeNode(5);
		BinaryTreeNode[] nodes2 = new BinaryTreeNode[10];

		for( int i=0;i<nodes2.length; i++ ){
			if( i >= 5 ){
				nodes2[i] = new BinaryTreeNode(i+1);
			}
			else
				nodes2[i] = new BinaryTreeNode(i);
		}

		tree2.left = nodes2[3];
		nodes2[3].left = nodes2[2];
		nodes2[3].right = nodes2[4];
		nodes2[2].left = nodes2[1];
		nodes2[1].left = nodes2[0];

		tree2.right = nodes2[7];
		nodes2[7].left = nodes2[5];
		nodes2[7].right = nodes2[8];
		nodes2[5].right = nodes2[6];
		nodes2[8].right = nodes2[9];

		tree2.print();

		System.out.println( isBST(tree2) );
	}
}

class BinaryTreeNode{

	public int data;
	public BinaryTreeNode left;
	public BinaryTreeNode right;

	BinaryTreeNode(){
		data = 0;
		left = right = null;
	}

	BinaryTreeNode( int d ){
		data = d;
		left = right = null;
	}

	public void print(){
		System.out.print( "[Tree]: " );
		printHelper( this );
		System.out.println( "" );
	}

	private void printHelper( BinaryTreeNode root ){
		if( null == root ){
			System.out.print( "# " );
			return;
		}

		System.out.print( root.data + " " );
		
		printHelper( root.left );
		printHelper( root.right );
	}
}
