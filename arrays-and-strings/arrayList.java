public class ArrayListCustom<E>
{
  private static final int INITIAL_CAPACITY = 10;
  private Object[] a;
  private int N = 0;
  
  public ArrayListCustom()
  { a = new Object[INITIAL_CAPACITY]; }
  
  public void add(E e)
  {
    if (N == a.length) resize();
    a[N++] = e;
  }
  
  public E get(int index)
  {
    if (index < 0 || index >= N) 
      throw new IndexOutofBoundsException("Index: " + index + ", Size: " + index);
    return (E) a[index];
  }
  
  public Object remove(int index)
  {
    if (index < 0 || index >= N) 
      throw new IndexOutofBoundsException("Index: " + index + ", Size: " + index);
    
    Object item = a[index];
    for (int i=index; i<N; i++)
      a[i] = a[i+1];
    N--;
    
    return item;
  }
}
