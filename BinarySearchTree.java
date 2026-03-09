//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import static java.lang.System.*;
import java.util.LinkedList;

public class BinarySearchTree
{
	private TreeNode root;

	public BinarySearchTree()
	{
		root = null;
	}

	public void add(Comparable val)
	{
		root = add(val, root);
	}

	private TreeNode add(Comparable val, TreeNode tree)
	{
	   if(tree == null)
			tree = new TreeNode(val);
		
		//complete the add method
		
		return tree;
	}

   public void inOrder()
	{
		inOrder(root);
		System.out.println("\n\n");
	}

	private void inOrder(TreeNode tree)
	{
		if (tree != null){
			inOrder(tree.getLeft());
			System.out.print(tree.getValue() + " ");
			inOrder(tree.getRight());
		}
	}

	//add preOrder
	
	//postOrder
	
	//and revOrder
	



	public int getNumLevels()
	{
		return getNumLevels(root);
	}

	private int getNumLevels(TreeNode tree)
	{
		//complete the num levels method
		return 0;
	}


	//methods to write

	//getNumLeaves
	
	//getDiameter
	
	//getWidth
	
	//getHeight
	
	//getNumNodes
	
	//isFull

	//search
	
	//getLargest
	
	//getSmallest
	
	//remove - delete
		
	//BONUS SECTION
	
	//level order
	
	//display like a tree



	public String toString()
	{
		return "";
	}

	private String toString(TreeNode tree)
	{
		return "";
	}
}