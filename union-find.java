public class QuickFind {
// Here is the id[] array after each union operation:

//       0 1 2 3 4 5 6 7 8 9 
// 4-8:  0 1 2 3 8 5 6 7 8 9 
// 0-8:  8 1 2 3 8 5 6 7 8 9 
// 2-9:  8 1 9 3 8 5 6 7 8 9 
// 5-9:  8 1 9 3 8 9 6 7 8 9 
// 3-7:  8 1 9 7 8 9 6 7 8 9 
// 8-7:  7 1 9 7 7 9 6 7 7 9 
  private int[] id;
  
  // set id of each obj to itself (n arr accesses)
  public QuickFind(int n) {
    id = new int[n];
    for (int i=0; i<n; i++) id[i] = i; 
  }
  
  // return the id of p (1 arr access)
  public int find(int p) {
    return id[p];
  }
  
  // change all entries with id[p] to id[q] (at most 2n+2 arr accesses)
  public void union(int p, int q) {
    int pid = id[p];
    int qid = id[q];
    for (int i=0; i<id.length; i++)
      if (id[i] == pid) id[i] = qid;
  }
}
public class QuickUnion {
  private int[] id;
  
  public QuickUnion(int n) {
    id = new int[n];
    for (int i=0; i<n; i++) id[i] = i;
  }
  
  // chase parent-pointers until reach root (depth of i)
  public int find(int i) {
    while (i != id[i]) i = id[i];
    return i;
  }
  
  // change root of p to point to root of q (depth of p and q)
  public void union(int p, int q) {
    int i= find(p);
    int j = find(q);
    id[i] = j;
  }
}
