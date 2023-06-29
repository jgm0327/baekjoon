import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main{

  private static int n, m;
  private static int[][] graph, time;
  private static Queue<int[]> one_virus, two_virus;
  private static boolean[][][] visit;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] size = br.readLine().split(" ");
    n = Integer.parseInt(size[0]);
    m = Integer.parseInt(size[1]);

    graph = new int[n][m];
    time = new int[n][m];
    one_virus = new LinkedList<>();
    two_virus = new LinkedList<>();
    visit = new boolean[n][m][3];

    for(int i=0 ; i<n ; i++){
      String[] values = br.readLine().split(" ");
      for(int j=0 ; j<m ; j++){
        graph[i][j] = Integer.parseInt(values[j]);
        if(graph[i][j] == 1){
          one_virus.add(new int[]{i, j, 0});
          visit[i][j][1] = true;
        }
        else if(graph[i][j] == 2){
          two_virus.add(new int[]{i, j, 0});
          visit[i][j][2] = true;
        }
      }
    }
    bfs();

    int one = 0, two = 0, three = 0;
    for(int i=0 ; i<n ; i++){
      for(int j=0 ; j<m ; j++){
        if(graph[i][j] == 1)one++;
        else if(graph[i][j] == 2)two++;
        else if(graph[i][j] == 3)three++;
      }
    }
    System.out.println(one + " " + two + " " + three);
    br.close();
  }

  private static void bfs(){
    final int[] dy = {0,0,1, -1}, dx = {1,-1,0,0};

    while(!one_virus.isEmpty() && !two_virus.isEmpty()){
      int s1 = one_virus.size(), s2 = two_virus.size();
      
      for(int t=0 ; t<s1 ; t++){
        int[] cur = one_virus.poll();
        int y = cur[0], x = cur[1], cnt = cur[2];
        if(graph[y][x] == 3)continue;
        // oneVirus
        for(int i=0 ; i<4 ; i++){
          int ny = y + dy[i], nx = x + dx[i];
          if(ny < 0 || ny >= n || nx < 0 || nx >= m || visit[ny][nx][1] || graph[ny][nx] == -1)continue;
          if(graph[ny][nx] != 0)continue;
          time[ny][nx] = cnt + 1;
          one_virus.add(new int[]{ny, nx, cnt + 1});
          visit[ny][nx][1] = true;
          graph[ny][nx] = 1;
          
        }
      }

      //twoVirus
      for(int t=0; t<s2 ; t++){
        int[] cur = two_virus.poll();
        int y = cur[0], x = cur[1], cnt = cur[2];
        for(int i=0 ; i<4 ; i++){
          int ny = y + dy[i], nx = x + dx[i];
          if(ny < 0 || ny >= n || nx < 0 || nx >= m || visit[ny][nx][2] || graph[ny][nx] == -1)continue;

          visit[ny][nx][2] = true;
          if(graph[ny][nx] == 1){
            if(time[ny][nx] == cnt + 1)graph[ny][nx] = 3;
            continue;
          }
          time[ny][nx] = cnt + 1;
          graph[ny][nx] = 2;
          two_virus.add(new int[]{ny, nx, cnt + 1});
          
        }
      }
    }

    while(!one_virus.isEmpty()){
      int[] cur = one_virus.poll();
      int y = cur[0], x = cur[1], cnt = cur[2];
      if(graph[y][x] == 3)continue;
      for(int i=0 ; i<4 ; i++){
        int ny = y + dy[i], nx = x + dx[i];
        if(ny < 0 || ny >= n || nx < 0 || nx >= m || visit[ny][nx][1] || graph[ny][nx] != 0)continue;
        if(graph[ny][nx] == 2){
          if(time[ny][nx] == cnt + 1)graph[ny][nx] = 3;
          continue;
        }
        one_virus.add(new int[]{ny, nx, cnt + 1});
        time[ny][nx] = cnt + 1;
        graph[ny][nx] = 1;
        visit[ny][nx][1] = true;
        
      }
    }

    while(!two_virus.isEmpty()){
      int[] cur = two_virus.poll();
      int y = cur[0], x = cur[1], cnt = cur[2];
      for(int i=0 ; i<4 ; i++){
        int ny = y + dy[i], nx = x + dx[i];
        if(ny < 0 || ny >= n || nx < 0 || nx >= m || visit[ny][nx][2] || graph[ny][nx] != 0)continue;
        if(graph[ny][nx] == 1){
          if(time[ny][nx] == cnt + 1)graph[ny][nx] = 3;
          continue;
        }
        two_virus.add(new int[]{ny, nx, cnt + 1});
        time[ny][nx] = cnt + 1;
        graph[ny][nx] = 2;
        visit[ny][nx][2] = true;
      }
    }
  }
}