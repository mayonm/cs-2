//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import static java.lang.System.*;
import java.util.LinkedList;

public class BSTree
{
	private TreeNode root;

	public BSTree()
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

		if(val.compareTo(tree.getValue()) < 0)
			tree.setLeft(add(val, tree.getLeft()));
		else if(val.compareTo(tree.getValue()) > 0)
			tree.setRight(add(val, tree.getRight()));

		return tree;
	}

	public void inOrder()
	{
		inOrder(root);
		System.out.println("\n\n");
	}

	private void inOrder(TreeNode tree)
	{
		if(tree != null){
			inOrder(tree.getLeft());
			System.out.print(tree.getValue() + " ");
			inOrder(tree.getRight());
		}
	}

	public void preOrder()
	{
		preOrder(root);
		System.out.println("\n\n");
	}

	private void preOrder(TreeNode tree)
	{
		if(tree != null){
			System.out.print(tree.getValue() + " ");
			preOrder(tree.getLeft());
			preOrder(tree.getRight());
		}
	}

	public void postOrder()
	{
		postOrder(root);
		System.out.println("\n\n");
	}

	private void postOrder(TreeNode tree)
	{
		if(tree != null){
			postOrder(tree.getLeft());
			postOrder(tree.getRight());
			System.out.print(tree.getValue() + " ");
		}
	}

	public void revOrder()
	{
		revOrder(root);
		System.out.println("\n\n");
	}

	private void revOrder(TreeNode tree)
	{
		if(tree != null){
			revOrder(tree.getRight());
			System.out.print(tree.getValue() + " ");
			revOrder(tree.getLeft());
		}
	}

	public void levelOrder()
	{
		if(root == null) return;
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty())
		{
			TreeNode current = queue.remove();
			System.out.print(current.getValue() + " ");
			if(current.getLeft() != null) queue.add(current.getLeft());
			if(current.getRight() != null) queue.add(current.getRight());
		}
		System.out.println();
	}

	public int getNumLevels()
	{
		return getNumLevels(root);
	}

	private int getNumLevels(TreeNode tree)
	{
		if(tree == null)
			return 0;
		return 1 + Math.max(getNumLevels(tree.getLeft()), getNumLevels(tree.getRight()));
	}

	public int getNumLeaves()
	{
		return getNumLeaves(root);
	}

	private int getNumLeaves(TreeNode tree)
	{
		if(tree == null)
			return 0;
		else if(tree.getLeft() == null && tree.getRight() == null)
			return 1;
		else
			return getNumLeaves(tree.getLeft()) + getNumLeaves(tree.getRight());
	}

	public int getDiameter()
	{
		return getDiameter(root);
	}

	private int getDiameter(TreeNode tree)
	{
		if(tree == null)
			return 0;
		int leftDiameter = getDiameter(tree.getLeft());
		int rightDiameter = getDiameter(tree.getRight());
		int longestPathThroughRoot = getNumLevels(tree.getLeft()) + getNumLevels(tree.getRight());
		return Math.max(longestPathThroughRoot, Math.max(leftDiameter, rightDiameter));
	}

	public int getWidth()
	{
		return getWidth(root);
	}

	private int getWidth(TreeNode tree)
	{
		if(tree == null)
			return 0;
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(tree);
		int maxWidth = 0;
		while(!queue.isEmpty())
		{
			int levelSize = queue.size();
			maxWidth = Math.max(maxWidth, levelSize);
			for(int i = 0; i < levelSize; i++)
			{
				TreeNode current = queue.remove();
				if(current.getLeft() != null) queue.add(current.getLeft());
				if(current.getRight() != null) queue.add(current.getRight());
			}
		}
		return maxWidth;  // FIX: was missing return
	}

	public int getHeight()
	{
		return getHeight(root);
	}

	private int getHeight(TreeNode tree)
	{
		if(tree == null)
			return -1;
		return 1 + Math.max(getHeight(tree.getLeft()), getHeight(tree.getRight()));
	}

	public int getNumNodes()
	{
		return getNumNodes(root);
	}

	private int getNumNodes(TreeNode tree)
	{
		if(tree == null)
			return 0;
		return 1 + getNumNodes(tree.getLeft()) + getNumNodes(tree.getRight());
	}

	public boolean isFull()
	{
		return isFull(root);
	}

	private boolean isFull(TreeNode tree)
	{
		if(tree == null)
			return true;
		if(tree.getLeft() == null && tree.getRight() == null)
			return true;
		if(tree.getLeft() != null && tree.getRight() != null)
			return isFull(tree.getLeft()) && isFull(tree.getRight());
		return false;
	}

	public boolean contains(Comparable val)
	{
		return search(val, root);
	}

	private boolean search(Comparable val, TreeNode tree)
	{
		if(tree == null)
			return false;
		if(val.compareTo(tree.getValue()) == 0)
			return true;
		else if(val.compareTo(tree.getValue()) < 0)
			return search(val, tree.getLeft());
		return search(val, tree.getRight());
	}

	public int getLargest()
	{
		return getLargest(root);
	}

	private int getLargest(TreeNode tree)
	{
		if(tree == null)
			return Integer.MIN_VALUE;
		int leftLargest = getLargest(tree.getLeft());
		int rightLargest = getLargest(tree.getRight());
		return Math.max((Integer)tree.getValue(), Math.max(leftLargest, rightLargest));
	}

	public int getSmallest()
	{
		return getSmallest(root);
	}

	private int getSmallest(TreeNode tree)
	{
		if(tree == null)
			return Integer.MAX_VALUE;
		int leftSmallest = getSmallest(tree.getLeft());
		int rightSmallest = getSmallest(tree.getRight());
		return Math.min((Integer)tree.getValue(), Math.min(leftSmallest, rightSmallest));
	}

	public void delete(Comparable val)
	{
		root = remove(val, root);
	}

	private TreeNode remove(Comparable val, TreeNode tree)
	{
		if(tree == null)
			return null;
		if(val.compareTo(tree.getValue()) < 0)
			tree.setLeft(remove(val, tree.getLeft()));
		else if(val.compareTo(tree.getValue()) > 0)
			tree.setRight(remove(val, tree.getRight()));
		else
		{
			// FIX: complete the deletion logic
			if(tree.getLeft() == null) return tree.getRight();
			if(tree.getRight() == null) return tree.getLeft();
			// Two children: replace with in-order successor (smallest in right subtree)
			TreeNode successor = tree.getRight();
			while(successor.getLeft() != null)
				successor = successor.getLeft();
			tree.setValue(successor.getValue());
			tree.setRight(remove(successor.getValue(), tree.getRight()));
		}
		return tree;
	}

	public String toString()
	{
		return "";
	}

	private String toString(TreeNode tree)
	{
		return "";
	}
}
