import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Map<Integer, Integer> map = new HashMap<>();

    StringBuilder answer = new StringBuilder();
    int n = Integer.parseInt(br.readLine());

    int[] arr = new int[n], tmp = new int[n];
    String[] values = br.readLine().split(" ");
    for(int i=0 ; i<n ; i++){
      arr[i] = Integer.parseInt(values[i]);
      tmp[i] = Integer.parseInt(values[i]);
    }
    Arrays.sort(tmp);

    map.put(tmp[0], 0);
    int cnt = 0;
    for(int i=1 ; i<n ; i++){
      if(tmp[i - 1] != tmp[i]){
        cnt++;
      }
      map.put(tmp[i], cnt);
    }

    for(int i=0 ; i<n ; i++){
      answer.append(map.get(arr[i]));
      answer.append(" ");
    }
    System.out.println(answer);

    br.close();
  }
}