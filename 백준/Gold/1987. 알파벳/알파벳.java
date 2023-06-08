import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Main{
  private static int n, m, answer;
  private static char[][] board;
  private static Map<Character, Boolean> visit;
  private static final int[] dy = {0,0,-1,1}, dx = {1,-1,0,0};

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] size = br.readLine().split(" ");
    n = Integer.parseInt(size[0]);
    m = Integer.parseInt(size[1]);
    board = new char[n][m];
    for(int i=0 ; i<n ; i++){
      String values = br.readLine();
      for(int j=0 ; j<m ; j++){
        board[i][j] = values.charAt(j);
      }
    }
    visit = new HashMap<>();
    visit.put(board[0][0], true);
    dfs(1, 0, 0);
    System.out.println(answer);
    br.close();
  }

  private static void dfs(int depth, int y, int x){
    answer = Math.max(answer, depth);
    for(int i=0 ; i<4 ; i++){
      int ny = y + dy[i], nx  = x + dx[i];
      if(ny < 0 || ny >= n || nx < 0 || nx >= m || visit.containsKey(board[ny][nx]))continue;
      visit.put(board[ny][nx], true);
      dfs(depth + 1, ny, nx);
      visit.remove(board[ny][nx]);
    }
  }
}