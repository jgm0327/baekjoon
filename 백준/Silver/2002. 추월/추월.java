import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n;
    Map<String, Integer> order = new HashMap<>();
    
    n = Integer.parseInt(br.readLine());
    for(int i=0 ; i<n; i++){
      order.put(br.readLine(), i);
    }
    
    String[] numbers = new String[n];
    for(int i=0 ; i<n ; i++){
      numbers[i] = br.readLine();
    }

    int cnt = 0;
    for(int i=0 ; i<n ; i++){
      for(int j=i+1 ; j<n ; j++){
        if(order.get(numbers[i]) > order.get(numbers[j])){
          cnt++;
          break;
        }
      }
    }

    System.out.println(cnt);
    br.close();
  }
}