import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Main{
  private static int n;
  private static int[] path;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    path = new int[n + 1];
    dikjstra();

    List<Integer> list = new ArrayList<>();
    int temp = 1;
    while(true){
      list.add(temp);
      if(temp == n)break;
      temp = path[temp];
    }
    Collections.reverse(list);
    System.out.println(list.size() - 1);
    for(int data : list){
      System.out.print(data + " ");
    }
    sc.close();
  }

  private static void dikjstra(){
    Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
    pq.add(new int[]{n, 1});
    int[] costs = new int[n + 1];
    Arrays.fill(costs, Integer.MAX_VALUE);
    costs[n] = 1;
    path[1] = n;

    while(!pq.isEmpty()){
      int[] cur = pq.poll();
      int num = cur[0], cnt = cur[1];
      if(cnt > costs[num])
        continue;
      if(num >= 1 && cnt + 1 <= costs[num - 1]){
        costs[num -1] = cnt + 1;
        path[num - 1] = num;
        pq.add(new int[]{num - 1, cnt + 1});
      }
      if(num % 2 == 0 && cnt + 1 <= costs[num / 2]){
        costs[num / 2] = cnt + 1;
        path[num / 2] = num;
        pq.add(new int[]{num / 2, cnt + 1});
      }
      if(num % 3 == 0 && cnt + 1 < costs[num / 3]){
        costs[num / 3] = cnt + 1;
        path[num / 3] = num;
        pq.add(new int[]{num / 3, cnt + 1});
      }
      }
  }
}