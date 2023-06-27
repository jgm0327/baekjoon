import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main{
  private static int n, m, k;
  private static int[][] graph;
  private static boolean[][][] visit;

  public static void main(String[] args) throws IOException{
    init();
    System.out.println(bfs());
  }

  private static void init() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    k = Integer.parseInt(br.readLine());
    String[] size = br.readLine().split(" ");
    m = Integer.parseInt(size[0]);
    n = Integer.parseInt(size[1]);

    graph = new int[n][m];
    visit = new boolean[n][m][k+1];
    for(int i=0 ; i<n ; i++){
      String[] values = br.readLine().split(" ");
      for(int j=0 ; j<m ; j++){
        graph[i][j] = Integer.parseInt(values[j]);
      }
    }

    br.close();
  }

  private static boolean isIn(int y, int x){
    return 0 <= y && y < n && 0 <= x && x < m;
  }

  private static int bfs(){
    if(0 == n -1 && 0 == m - 1)return 0;
    Queue<int[]> que = new LinkedList<>();
    final int[] dy = {0,0,1,-1}, dx = {1,-1,0,0};
    final int[] h_dy = {-2, -2, -1, 1, 2, 2, 1, -1}, h_dx = {-1, 1, 2, 2, 1, -1, -2, -2};
    que.add(new int[]{0, 0, 0, 0}); // y, x, cnt, k,
    
    while(!que.isEmpty()){
      int[] cur = que.poll();
      int y = cur[0], x = cur[1], cnt = cur[2], curk = cur[3];
      if(y == n - 1 && x == m - 1)return cnt;

      // 상하좌우
      for(int i=0 ; i<4 ; i++){
        int ny = y + dy[i], nx = x + dx[i];
        if(!isIn(ny, nx) || graph[ny][nx] == 1 || visit[ny][nx][curk])continue;
        que.add(new int[]{ny, nx, cnt+1, curk});
        visit[ny][nx][curk] = true;
      }

      // 말처럼
      if(curk == k)continue;
      for(int i=0 ; i<8 ; i++){
        int ny = y + h_dy[i], nx = x + h_dx[i];
        if(!isIn(ny, nx) || graph[ny][nx] == 1 || visit[ny][nx][curk+1])continue;
        que.add(new int[]{ny, nx, cnt+1, curk+1});
        visit[ny][nx][curk+1] = true;
      }
    }
    return - 1;
  }
}