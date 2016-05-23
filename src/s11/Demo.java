package s11;

public class Demo {
  static void demo(int n) {
    QueueChained<Integer> f;
    int i, sum = 0;
    f = new QueueChained<>();
    for (i = 0; i < n; i++)
      f.enqueue(i);
    while (!f.isEmpty())
      sum = sum + f.dequeue();
    System.out.println(sum);
  }
}