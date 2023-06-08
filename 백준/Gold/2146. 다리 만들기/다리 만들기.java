import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Main{
  private static int n, answer;
  private static int[][] graph;
  private static final int[] dy = {0,0,1,-1}, dx = {1,-1,0,0};
  private static boolean[][] already;

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    graph = new int[n][n];

    for(int i=0 ; i<n ; i++){
      String[] values = br.readLine().split(" ");
      for(int j=0 ; j<n ; j++){
        graph[i][j] = Integer.parseInt(values[j]);
      }
    }

    already = new boolean[n][n];

    int cnt = 1;
    List<int[]> start = new ArrayList<>();
    for(int i=0 ; i<n ; i++){
      for(int j=0 ; j<n ; j++){
        if(!already[i][j] && graph[i][j] == 1){
          graph[i][j] = cnt;
          setNumber(i, j, cnt++);
        }
      }
    }

    answer = Integer.MAX_VALUE;
    for(int i=0 ; i<n ; i++){
      for(int j=0 ; j<n ; j++){
        if(graph[i][j] != 0) findShortestBridge(i, j);
      }
    }
    System.out.println(answer);
    br.close();
  }

  private static void setNumber(int cy, int cx, int num){
    Queue<int[]> que = new LinkedList<>();
    que.add(new int[]{cy, cx});
    already[cy][cx] = true;
    while(!que.isEmpty()){
      int[] cur = que.poll();
      int y = cur[0], x = cur[1];

      for(int i=0 ; i<4 ; i++){
        int ny = y + dy[i], nx = x + dx[i];
        if(ny < 0 || ny >= n || nx < 0 || nx >= n || already[ny][nx] || graph[ny][nx] == 0)continue;
        que.add(new int[]{ny, nx});
        graph[ny][nx] = num;
        already[ny][nx] = true;
      }
    }
  }

  private static void findShortestBridge(int cy, int cx){
    Queue<int[]> que = new LinkedList<>();
    que.add(new int[]{cy, cx, 0});
    boolean[][] visit = new boolean[n][n];
    visit[cy][cx] = true;

    while(!que.isEmpty()){
      int[] cur = que.poll();
      int y = cur[0], x = cur[1], cnt = cur[2];
      if(cnt >= answer)return;

      for(int i=0 ; i<4 ; i++){
        int ny = y + dy[i], nx = x + dx[i];
        if(ny < 0 || ny >= n || nx < 0 || nx >= n || visit[ny][nx] || graph[ny][nx] == graph[cy][cx])continue;
        if(graph[ny][nx] != graph[cy][cx] && graph[ny][nx] != 0){
          answer = Math.min(answer, cnt);
          return;
        }
        que.add(new int[]{ny, nx, cnt + 1});
        visit[ny][nx] = true;
      }
    }
  }
}