import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main{
  private static int n, m;
  private static List<Integer>[] countries;
  private static int[] parents, path;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());

    countries = new ArrayList[n + 1];
    parents = new int[n + 1];
    for(int i=0 ; i<=n ; i++){
      parents[i] = i;
      countries[i] = new ArrayList<>();
    }

    for(int i=0 ; i<n ; i++){
      String[] values = br.readLine().split(" ");
      for(int j=0 ; j<n ; j++){
        if(Integer.parseInt(values[j]) == 0)continue;
        if(findParent(i + 1) != findParent(j + 1))
          union(i + 1, j + 1);
      }
    }

    path = new int[m];
    String[] values = br.readLine().split(" ");
    for(int i=0 ; i<m ; i++){
      path[i] = Integer.parseInt(values[i]);
    }
    System.out.println(print());
    br.close();
  }

  private static String print(){
    for(int i = 0 ; i < m - 1; i++){
      if(findParent(path[i]) != findParent(path[i + 1]))
        return "NO";
    }
    return "YES";
  } 

  private static int findParent(int x){
    if(x == parents[x])return x;
    return parents[x] = findParent(parents[x]);
  }

  private static void union(int x, int y){
    int px = findParent(x), py = findParent(y);
    if(px == py)return;

    parents[px] = py;
  }
}