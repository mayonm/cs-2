//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class BSTreeRunner
{
   public static void main( String args[] )
   {
      BSTree tree = new BSTree();

      tree.add(90);
      tree.add(80);
      tree.add(100);
      tree.add(70);
      tree.add(85);
      tree.add(98);
      tree.add(120);

      out.println("IN ORDER");
      tree.inOrder();
      out.println();

      out.println("PRE ORDER");
      tree.preOrder();
      out.println();

      out.println("POST ORDER");
      tree.postOrder();
      out.println();

      out.println("REVERSE ORDER");
      tree.revOrder();
      out.println();

      out.println("Tree height is "    + tree.getHeight());
      out.println("Tree diameter is "  + tree.getDiameter());
      out.println("Tree width is "     + tree.getWidth());
      out.println("Number of leaves is " + tree.getNumLeaves());
      out.println("Number of nodes is "  + tree.getNumNodes());
      out.println("Number of levels is " + tree.getNumLevels());

      out.println("Tree as a string   " + tree);

      if (tree.isFull())
         out.println("The tree is full.");
      else
         out.println("The tree is not full.");

      int searchVal1 = 100;
      int searchVal2 = 114;
      if (tree.contains(searchVal1))
         out.println("The tree contains " + searchVal1 + "!");
      else
         out.println("The tree does not contain " + searchVal1 + "!");

      if (tree.contains(searchVal2))
         out.println("The tree contains " + searchVal2 + "!");
      else
         out.println("The does not contain " + searchVal2 + "!");

      out.println("The smallest tree node " + tree.getSmallest());
      out.println("The largest tree node "  + tree.getLargest());

      out.println("\nTree before removing any nodes - using level order traversal.");
      tree.levelOrder();
      out.println();

      int[] toRemove = {90, 70, 85, 98, 80, 120, 100};
      for (int val : toRemove)
      {
         tree.delete(val);
         out.println("Tree after removing " + val + ".");
         tree.levelOrder();
         out.println();
      }
   }
}
