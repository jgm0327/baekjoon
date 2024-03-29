import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
  private static int n, k;
  private static int[] arr;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for(int i=0 ; i<n ; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    System.out.println(solution());
    br.close();
  }

  private static int solution(){
    int[] count = new int[100001];
    int start = 0, end = 0, ret=0;
    while(end < n){
      count[arr[end]]++;
      while(start <= end && count[arr[end]] > k){
        count[arr[start]]--;
        start++;
      }
      ret = Math.max(ret, end - start + 1);
      end++;
    }
    return ret;
  }
}