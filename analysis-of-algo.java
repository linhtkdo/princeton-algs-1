class DoublingHypothesis {
  N     T
  2000  0.8
  4000  6.4
  
  Running time is about aN^b with b = log (base2) ratio
  log (base2) (6.4 / 0.8) = 3.0
}
class MathModel {
What is the order of growth of the worst case running time of the following code fragment
as a function of N?

int sum = 0;
for (int i = 0; i < N; i++)
    for (int j = i; j < N; j++)
        for (int k = i; k <= j; k++)
            sum++;
            
The answer is : N^3

For a given value of i, the body of the innermost loop is executed 1 + 2 + 3 + 4 + ... + (N-i) ~ 1/2 (N-i)^2. 
Summing this up over all i yields ~ 1/6 N^3.
}
class Memory {
Using the 64-bit memory cost model from lecture, how many bytes does each object of type MysteryBox use? 
Include all memory allocated when the client calls new MysteryBox().

public class MysteryBox {                           //   16 (object overhead)
    private final long x0, x1, x2;                  //   24 (3 long)
    private final int y0, y1, y2;                   //   12 (3 int)
    private final boolean z0, z1, z2, z3;           //    4 (4 boolean)
    private final double[] a = new double[32];      //    8 (reference to array)
                                                    //  280 (double array of size 32)
    ...                                                   0 (padding to round up to a multiple of 8)
}                                                      ----
                                                        344
}
