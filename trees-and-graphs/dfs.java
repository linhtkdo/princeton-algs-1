public class DepthFirstSearch
{
    // preferred if we want to visit every node in the graph
    
    private boolean[] marked;               // true if connected to s
    
    public DepthFirstSearch(Graph G, int s) // constructor marks vertices connected to s
    {
        marked = new boolean[G.V()];
        dfs(G, s);
    }
    
    private void dfs(Graph G, int v)        // recursive dfs does the work
    {
        // DFS (to visit a vertex v)
        // Mark v as visited.
        // Recursively visit all unmarked vertices w pointing from v.
        
        marked[v] = true;
        for (int w : G.adj(v))
            if (!marked[w]) dfs(G, w);
    }
    
    public boolean visited(int v)           // client can ask whether any vertex is connected to s
    {   return marked[v];   }
}
