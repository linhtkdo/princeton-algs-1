public class Graph
{
    // adj lists (using Bag data type)
    private final int V;
    private Bag<Integer>[] adj; 
    
    // create empty graph with V vertices
    public Graph(int V)
    {
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++)
            adj[v] = new Bag<Integer>();
    }
    
    // add edge v-w
    public void addEdge(int v, int w)
    {
        adj[v].add(w);
        adj[w].add(v);
    }
}
