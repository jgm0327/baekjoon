import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main{

  private static int n;
  private static int[][] map, dp;
  private static final int[] dy = {0,0,-1,1}, dx = {1,-1,0,0};

  public static void main(String[] args) throws IOException{
    init();
    solution();
  }

  private static void init() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    map = new int[n][n];
    dp = new int[n][n];
    for(int i=0 ; i<n ; i++){
      String[] values = br.readLine().split(" ");
      for(int j=0 ; j<n ; j++){
        map[i][j] = Integer.parseInt(values[j]);
      }
    }

    br.close();
  }

  private static void solution(){
    int answer = 0;
    for(int i=0 ; i<n ; i++){
      for(int j=0 ; j<n ; j++){
        answer = Math.max(dfs(i, j), answer);
      }
    }
    System.out.println(answer);
  }

  private static int dfs(int y, int x){
    if(dp[y][x] != 0)return dp[y][x];

    dp[y][x] = 1;

    for(int i=0 ; i<4 ; i++){
      int ny = y + dy[i], nx = x + dx[i];
      if(ny < 0 || ny >= n || nx < 0 || nx >= n || map[y][x] >= map[ny][nx])continue;
      dp[y][x] = Math.max(dp[y][x], dfs(ny, nx) + 1);
    }
    return dp[y][x];
  }
}