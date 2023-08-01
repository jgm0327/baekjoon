import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main{
  private static int n;
  private static int[][] graph;
  private static long[][] costs;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    graph = new int[n][n];
    costs = new long[n][n];
    for(int i=0 ;i<n ; i++)
      Arrays.fill(costs[i], Integer.MAX_VALUE);

    for(int i=0 ; i<n ; i++){
      String[] values = br.readLine().split(" ");
      for(int j=0 ; j<n ; j++){
        graph[i][j] = Integer.parseInt(values[j]);
        if(graph[i][j] == 1)costs[i][j] = 1;
      }
    }
    
    for(int k=0 ; k<n ; k++){
      for(int i=0 ; i<n ; i++){
        for(int j=0 ; j<n ; j++){
          if(costs[i][j] <= costs[i][k] + costs[k][j])continue;
          costs[i][j] = costs[i][k] + costs[k][j];
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    for(int i=0 ; i<n ; i++){
      for(int j=0 ; j<n ; j++){
        if(costs[i][j] >= Integer.MAX_VALUE)sb.append(0 + " ");
        else sb.append(1 + " ");
      }
      sb.append("\n");
    }
    System.out.print(sb);
    br.close();
  }
}