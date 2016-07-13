public class BreathFirstPaths
{
    private boolean[] marked;
    ...
    private void bfs(Graph G, int s)
    {
        // Repeat until queue is empty: 
        //     Remove(visit) vertex v from queue.
        //     Add to queue all unmarked vertices adjacent to v and mark them.
        
        Queue<Integer> q = new Queue<Integer>();    // init FIFO queue of vertices to explore
        q.enqueue(s);                               // add to end of queue
        marked[s] = true;
        
        while (!q.isEmpty())
        {
            int v = q.dequeue(); visit(v);          // remove from front of queue
            for (int w : G.adj(v))
                if (!marked[w]) { q.enqueue(w); marked[w] = true; }
        }
    }
}
