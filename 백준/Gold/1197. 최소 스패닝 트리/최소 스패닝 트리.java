import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

class Main{
  private static int n, m;
  private static int[] parents;
  private static Queue<int[]> pq;

  public static void main(String[] args) throws IOException{
    init();
    mst();
  }

  private static void init() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] size = br.readLine().split(" ");
    n = Integer.parseInt(size[0]);
    m = Integer.parseInt(size[1]);
    pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

    for(int i=0 ; i<m ; i++){
      String[] values = br.readLine().split(" ");
      int sour = Integer.parseInt(values[0]), des = Integer.parseInt(values[1]), cost = Integer.parseInt(values[2]);
      pq.add(new int[]{sour, des, cost});
    }

    parents = new int[n+1];
    for(int i=1 ; i<=n ; i++)parents[i] = i;
    br.close();
  }

  private static void mst(){
    int answer = 0;
    while(!pq.isEmpty()){
      int[] cur = pq.poll();
      int sour = cur[0], des = cur[1], cost = cur[2];
      if(findParents(sour) == findParents(des))continue;
      union(sour, des);
      answer += cost;
    }

    System.out.println(answer);
  }

  private static int findParents(int x){
    if(x == parents[x])return x;
    return parents[x] = findParents(parents[x]);
  }

  private static void union(int x, int y){
    int px = findParents(x), py = findParents(y);
    if(px == py)return;
    parents[py] = px;
  }
}