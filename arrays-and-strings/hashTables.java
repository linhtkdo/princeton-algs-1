public class SeparateChainingHashST<Key, Value>
{
    private int M = 97;                 // number of chains
    private Node[] st = new Node[M];    // array of chains
    
    private static class Node
    {
        private Object key;
        private Object val;
        private Node next;
        public Node(Key key, Value val, Node next)
        {   this.key = key; this.val = val; this.next = next;   }
    }
    
    // Hash: map key to integer i between 0 and M - 1.
    private int hash(Key key)
    {   return (key.hashCode() & 0x7fffffff) % M;   }
    
    // Search: need to search only ith chain.
    public Value get(Key key)
    {
        int i = hash(key);
        for (Node x = st[i]; x!= null; x = x.next)
            if (key.equals(x.key)) return (Value) x.val;
        return null;
    }
    
    // Insert: put at front of ith chain (if not already there).
    public void put(Key key, Value val)
    {
        int i = hash(key);
        for (Node x = st[i]; x != null; x = x.next)
            if (key.equals(x.key)) { x.val = val; return; }
        st[i] = new Node(key, val, st[i]);
    }
  
}
