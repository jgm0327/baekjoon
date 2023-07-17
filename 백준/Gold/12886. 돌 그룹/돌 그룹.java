import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

class Main{
  public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
    System.out.println(bfs(a, b, c));
  }

  private static int bfs(int a, int b, int c){
    Queue<int[]> que = new LinkedList<>();
    Map<String, Boolean> visit = new HashMap<>();
    que.add(new int[]{a, b, c});
    visit.put(getKey(a, b, c), true);

    while(!que.isEmpty()){
      int[] cur = que.poll();
      if(cur[0] == cur[1] && cur[1] == cur[2])return 1;
      for(int i=0 ; i<3 ; i++){
        int max = Math.max(cur[i], cur[(i+1) % 3]);
        int min = Math.min(cur[i], cur[(i+1) % 3]);
        String key = getKey(max - min, 2 * min, cur[(i + 2) % 3]);
        if(visit.containsKey(key))continue;
        visit.put(key, true);
        que.add(new int[]{2 * min, max - min, cur[(i+2) % 3]});
      }
    }
    return 0;
  }

  private static String getKey(int a, int b, int c){
    StringBuilder sb = new StringBuilder();
    sb.append(a);
    sb.append(" ");
    sb.append(b);
    sb.append(" ");
    sb.append(c);
    sb.append(" ");
    return sb.toString();
  }
}