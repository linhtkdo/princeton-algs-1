public class BST<Key extends Comparable<Key>, Value>
{
    private Node root;
    
    private class Node
    {
        private Key key;
        private Value val;
        private Node left, right;
        public Node(Key key, Value val)
        {
            this.key = key;
            this.val = val;
        }
    }
    
    // inorder traversal of a BST yields keys in ascending order
    public void inorder(Node x)
    {
        if (x == null) return;
        inorder(x.left);
        visit(x);
        inorder(x.right);
    }
}
