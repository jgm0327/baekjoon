import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main{
  private static int n, m;
  private static int[][] maze;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] size = br.readLine().split(" ");
    n = Integer.parseInt(size[0]);
    m = Integer.parseInt(size[1]);

    maze = new int[n][m];
    for(int i=0 ; i<n ; i++){
      String str = br.readLine();
      for(int j=0 ; j<m ; j++){
        maze[i][j] = (str.charAt(j) - '0');
      }
    }

    System.out.println(bfs());

    br.close();
  }

  private static int bfs(){
    Queue<int[]> que = new LinkedList<>();
    que.add(new int[]{0,0,1});
    boolean[][] visit = new boolean[n][m];
    visit[0][0] = true;
    final int[] dy = {0,0,1,-1}, dx = {1,-1,0,0};

    while(!que.isEmpty()){
      int[] cur = que.poll();
      int y = cur[0], x = cur[1], cnt = cur[2];
      for(int i=0 ; i<4 ; i++){
        int ny = y + dy[i], nx = x + dx[i];
        if(ny == n - 1 && nx == m - 1)return cnt + 1;
        if(ny < 0 || ny >= n || nx < 0 || nx >= m || visit[ny][nx] || maze[ny][nx] == 0)
          continue;
        visit[ny][nx] = true;
        que.add(new int[]{ny, nx, cnt + 1});
      }
    }
    return -1;
  }

}