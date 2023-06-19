import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{

  private static int n, m, answer;
  private static int[] arr;
  private static boolean[] visit;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] size = br.readLine().split(" ");
    n = Integer.parseInt(size[0]);
    m = Integer.parseInt(size[1]);
    visit = new boolean[n];
    arr = new int[n];

    String[] str = br.readLine().split(" ");
    for(int i=0 ; i<n ; i++){
      arr[i] = Integer.parseInt(str[i]);
    }

    recur(0, 0);

    System.out.println(answer);
    br.close();
  }

  private static void recur(int total, int idx){
    if(idx >= n){
      return;
    }

    for(int i=idx ; i<n ; i++){
      if(visit[i])continue;
      total += arr[i];
      if(total == m)answer++;
      visit[i] = true;
      recur(total, i + 1);
      total -= arr[i];
      visit[i] = false;
    }
  }

}