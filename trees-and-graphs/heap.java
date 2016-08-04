public class MaxPQ<Key extends Comparable<Key>>
{
    private Key[] pq;
    private int N;
    
    public MaxPQ(int capacity)
    {   pq = (Key[]) new Comparable[capacity+1];    }
    
    // PQ ops
    public boolean isEmpty()
    {   return N == 0;  }
    
    public void insert(Key x)   // O(log n)
    {
        pq[++N] = x;    // add node at end
        swim(N);        // swim it up
    }
    
    public Key delMax()         // O(log n)     
    {
        Key max = pq[1];
        exch(1, N--);   // exchange root with node at end
        sink(1);        // sink it down
        pq[N+1] = null; // remove max node from heap
        return max;
    }
    
    // heap helper fxn
    private void swim(int k) 
    {
        while (k > 1 && less(k/2, k)) // parent of node at k is at k/2
        {
            exch(k, k/2);
            k = k/2;
        }
    }
    
    private void sink(int k) 
    {
        while (2*k <= N)
        {
            int j = 2*k;
            if (j < N && less (j, j+1)) j++; //children of node at k are 2k and 2k+1; find the larger child
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
    
    // arr helper fxn
    private boolean less (int i, int j)
    {   return pq[i].compareTo(pq[j]) < 0;  }
    private void exch(int i, int j)
    {   Key t = pq[i]; pq[i] = pq[j]; pq[j] = t;    }
    
}
