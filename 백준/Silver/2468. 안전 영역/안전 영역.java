import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main{
  private static int n;
  private static int[][] buildings;
  private static boolean[][] visit;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    buildings = new int[n][n];
    int maxHeight = 0;
    for(int i=0 ; i<n ; i++){
      String[] values = br.readLine().split(" ");
      for(int j=0 ; j<n ; j++){
        buildings[i][j] = Integer.parseInt(values[j]);
        maxHeight = Math.max(maxHeight, buildings[i][j]);
      }
    }

    int answer = 0;
    for(int h=1 ; h<=maxHeight ; h++){
      visit = new boolean[n][n];
      int cnt = 0;
      for(int i=0 ; i<n ; i++){
        for(int j=0 ; j<n ; j++){
          if(buildings[i][j] < h || visit[i][j]) continue;
          cnt++;
          bfs(i, j, h);
        }
      }
      answer = Math.max(answer, cnt);
    }

    System.out.println(answer);
    br.close();
  }

  private static void bfs(int sy, int sx, int h){
    Queue<int[]> que = new LinkedList<>();
    que.add(new int[]{sy, sx});
    final int[] dy = {0,0,1,-1}, dx = {1,-1,0,0};
    visit[sy][sx] = true;

    while(!que.isEmpty()){
      int[] cur = que.poll();
      int y =  cur[0], x = cur[1];
      for(int i=0 ; i<4 ; i++){
        int ny = y + dy[i], nx = x + dx[i];
        if(ny < 0 || ny >= n || nx < 0 || nx >= n || visit[ny][nx] || h > buildings[ny][nx])
          continue;
        que.add(new int[]{ny, nx});
        visit[ny][nx] = true;
      }
    }
  }
}