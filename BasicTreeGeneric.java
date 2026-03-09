import java.util.LinkedList;

public class BasicTreeGeneric<T extends Comparable<T>>
{
    private static class Node<T>
    {
        T value;
        Node<T> left, right;

        Node(T value)
        {
            this.value = value;
            left  = null;
            right = null;
        }
    }

    private Node<T> root;

    public BasicTreeGeneric()
    {
        root = null;
    }

    public void add(T val)
    {
        root = add(val, root);
    }

    private Node<T> add(T val, Node<T> tree)
    {
        if (tree == null)
            return new Node<>(val);

        if (val.compareTo(tree.value) < 0)
            tree.left = add(val, tree.left);
        else if (val.compareTo(tree.value) > 0)
            tree.right = add(val, tree.right);

        return tree;
    }


    public void inOrder()
    {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node<T> tree)
    {
        if (tree != null) {
            inOrder(tree.left);
            System.out.print(tree.value + " ");
            inOrder(tree.right);
        }
    }

    public void preOrder()
    {
        preOrder(root);
        System.out.println();
    }

    private void preOrder(Node<T> tree)
    {
        if (tree != null) {
            System.out.print(tree.value + " ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    public void postOrder()
    {
        postOrder(root);
        System.out.println();
    }

    private void postOrder(Node<T> tree)
    {
        if (tree != null) {
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.print(tree.value + " ");
        }
    }

    public void revOrder()
    {
        revOrder(root);
        System.out.println();
    }

    private void revOrder(Node<T> tree)
    {
        if (tree != null) {
            revOrder(tree.right);
            System.out.print(tree.value + " ");
            revOrder(tree.left);
        }
    }


    public int getHeight()
    {
        return getHeight(root);
    }

    private int getHeight(Node<T> tree)
    {
        if (tree == null)
            return -1;
        return 1 + Math.max(getHeight(tree.left), getHeight(tree.right));
    }

    public int getNumLevels()
    {
        return getNumLevels(root);
    }

    private int getNumLevels(Node<T> tree)
    {
        if (tree == null)
            return 0;
        return 1 + Math.max(getNumLevels(tree.left), getNumLevels(tree.right));
    }

    public int getNumLeaves()
    {
        return getNumLeaves(root);
    }

    private int getNumLeaves(Node<T> tree)
    {
        if (tree == null)
            return 0;
        if (tree.left == null && tree.right == null)
            return 1;
        return getNumLeaves(tree.left) + getNumLeaves(tree.right);
    }

    public int getNumNodes()
    {
        return getNumNodes(root);
    }

    private int getNumNodes(Node<T> tree)
    {
        if (tree == null)
            return 0;
        return 1 + getNumNodes(tree.left) + getNumNodes(tree.right);
    }

    public int getDiameter()
    {
        return getDiameter(root);
    }

    private int getDiameter(Node<T> tree)
    {
        if (tree == null)
            return 0;
        int leftDiam    = getDiameter(tree.left);
        int rightDiam   = getDiameter(tree.right);
        int throughRoot = getNumLevels(tree.left) + getNumLevels(tree.right);
        return Math.max(throughRoot, Math.max(leftDiam, rightDiam));
    }

    public int getWidth()
    {
        if (root == null) return 0;
        LinkedList<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        int maxWidth = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            maxWidth = Math.max(maxWidth, levelSize);
            for (int i = 0; i < levelSize; i++) {
                Node<T> current = queue.remove();
                if (current.left  != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
        }
        return maxWidth;
    }

    public boolean isFull()
    {
        return isFull(root);
    }

    private boolean isFull(Node<T> tree)
    {
        if (tree == null)
            return true;
        if (tree.left == null && tree.right == null)
            return true;
        if (tree.left != null && tree.right != null)
            return isFull(tree.left) && isFull(tree.right);
        return false;
    }

    public String toString()
    {
        return toString(root).trim();
    }

    private String toString(Node<T> tree)
    {
        if (tree == null) return "";
        return toString(tree.left) + tree.value + " " + toString(tree.right);
    }


    public boolean contains(T val)
    {
        return search(val, root);
    }

    private boolean search(T val, Node<T> tree)
    {
        if (tree == null) return false;
        int cmp = val.compareTo(tree.value);
        if (cmp == 0) return true;
        if (cmp < 0)  return search(val, tree.left);
        return search(val, tree.right);
    }


    public T getLargest()
    {
        if (root == null) return null;
        Node<T> cur = root;
        while (cur.right != null)
            cur = cur.right;
        return cur.value;
    }

    public T getSmallest()
    {
        if (root == null) return null;
        Node<T> cur = root;
        while (cur.left != null)
            cur = cur.left;
        return cur.value;
    }


    public void levelOrder()
    {
        if (root == null) return;
        LinkedList<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<T> current = queue.remove();
            System.out.print(current.value + " ");
            if (current.left  != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        System.out.println();
    }


    public void remove(T val)
    {
        root = remove(val, root);
    }

    private Node<T> remove(T val, Node<T> tree)
    {
        if (tree == null) return null;
        int cmp = val.compareTo(tree.value);
        if (cmp < 0)
            tree.left = remove(val, tree.left);
        else if (cmp > 0)
            tree.right = remove(val, tree.right);
        else {
            if (tree.left  == null) return tree.right;
            if (tree.right == null) return tree.left;
            // Two children: replace with in-order successor (min of right subtree)
            Node<T> successor = tree.right;
            while (successor.left != null)
                successor = successor.left;
            tree.value = successor.value;
            tree.right = remove(successor.value, tree.right);
        }
        return tree;
    }


    public void display()
    {
        if (root == null) return;
        LinkedList<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        boolean isRoot = true;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            if (isRoot) {
                System.out.println("ROOT");
                isRoot = false;
            }
            for (int i = 0; i < levelSize; i++) {
                Node<T> current = queue.remove();
                System.out.print(current.value);
                if (i < levelSize - 1) System.out.print(" ");
                if (current.left  != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
            System.out.println();
        }
    }
}
