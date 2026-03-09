public class BasicTreeGenericRunner
{
    public static void main(String[] args)
    {
        BasicTreeGeneric<Integer> tree = new BasicTreeGeneric<>();
        tree.add(90);
        tree.add(80);
        tree.add(70);
        tree.add(85);
        tree.add(100);
        tree.add(98);
        tree.add(120);

        System.out.println("IN ORDER");
        tree.inOrder();

        System.out.println("PRE ORDER");
        tree.preOrder();

        System.out.println("POST ORDER");
        tree.postOrder();

        System.out.println("REVERSE ORDER");
        tree.revOrder();

        System.out.println("Tree height is " + tree.getHeight());
        System.out.println("Tree width is " + tree.getWidth());
        System.out.println("Number of leaves is " + tree.getNumLeaves());
        System.out.println("Number of nodes is " + tree.getNumNodes());
        System.out.println("Number of levels is " + tree.getNumLevels());
        System.out.println("Tree as a string " + tree.toString());

        if (tree.isFull())
            System.out.println("The tree is full.");
        else
            System.out.println("The tree is not full.");

        System.out.println();
        tree.display();
        System.out.println();

        System.out.println("height = "     + tree.getHeight());
        System.out.println("width = "      + tree.getWidth());
        System.out.println("numLevels = "  + tree.getNumLevels());
        System.out.println("numLeaves = "  + tree.getNumLeaves());
        System.out.println("numNodes = "   + tree.getNumNodes());
        System.out.println("isFullTree = " + tree.isFull());

        // BONUS
        System.out.println();
        if (tree.contains(100))
            System.out.println("The tree contains 100!");
        else
            System.out.println("The tree does not contain 100!");

        if (tree.contains(114))
            System.out.println("The tree contains 114!");
        else
            System.out.println("The does not contain 114!");

        System.out.println("The smallest tree node " + tree.getSmallest());
        System.out.println("The largest tree node "  + tree.getLargest());

        System.out.println();
        System.out.println("Tree before removing any nodes - using level order traversal.");
        tree.levelOrder();

        int[] toRemove = {90, 70, 85, 98, 80, 120, 100};
        for (int val : toRemove) {
            tree.remove(val);
            System.out.println("Tree after removing " + val + ".");
            tree.levelOrder();
        }
    }
}
