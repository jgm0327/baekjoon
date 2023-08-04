import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Main{
  private static int n, m;
  private static Map<Integer, Integer> count;
  private static int[][] answer, board, save;
  private static List<int[]> blanks;
  private static boolean[][] visit;
  private static final int[] dy = {0, 0, 1, -1}, dx = {1, -1, 0, 0};
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] size = br.readLine().split(" ");
    n = Integer.parseInt(size[0]);
    m = Integer.parseInt(size[1]);

    answer = new int[n][m];
    blanks = new ArrayList<>();
    board = new int[n][m];
    save = new int[n][m];
    visit = new boolean[n][m];
    count = new HashMap<>();

    for(int i=0 ; i<n ; i++){
      String values = br.readLine();
      for(int j=0 ; j<m ; j++){
        board[i][j] = (int)(values.charAt(j) - '0');
        if(board[i][j] == 0)blanks.add(new int[]{i, j});
        else answer[i][j]++;
      }
    }

    int cnt = 0;
    for(int[] point : blanks){
      int y = point[0], x = point[1];
      if(visit[y][x])continue;
      count.put(++cnt, bfs(y, x, cnt));
    }

    StringBuilder sb = new StringBuilder();
    for(int i=0 ; i<n ; i++){
      for(int j=0 ; j<m ; j++){
        if(board[i][j] == 0)sb.append("0");
        else sb.append(count(i, j) % 10);
      }
      sb.append("\n");
    }
    System.out.print(sb);
    br.close();
  }

  private static int bfs(int sy, int sx, int num){
    Queue<int[]> que = new LinkedList<>();
    que.add(new int[]{sy, sx});
    visit[sy][sx] = true;
    int cnt = 0;
    while(!que.isEmpty()){
      int[] cur = que.poll();
      int y = cur[0], x = cur[1];
      save[y][x] = num;
      cnt++;
      for(int i=0 ; i<4 ; i++){
        int ny = y + dy[i], nx = x + dx[i];
        if(ny < 0 || ny >= n || nx < 0 || nx >= m || visit[ny][nx] || board[ny][nx] !=0)
          continue;
        que.add(new int[]{ny, nx});
        visit[ny][nx] = true;
      }
    }
    return cnt;
  }

  private static int count(int y, int x){
    Map<Integer, Boolean> v = new HashMap<>();
    int ret = 1;
    for(int i=0 ; i<4 ; i++){
      int ny = y + dy[i], nx = x + dx[i];
        if(ny < 0 || ny >= n || nx < 0 || nx >= m || v.containsKey(save[ny][nx]) || !count.containsKey(save[ny][nx]))
          continue;
        ret += count.get(save[ny][nx]);
        v.put(save[ny][nx], true);
    }
    return ret;
  }
}            