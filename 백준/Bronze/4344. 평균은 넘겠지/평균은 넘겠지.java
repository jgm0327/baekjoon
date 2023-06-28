import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main{

  private static int[] scores;
  public static void main(String[] args) throws IOException{
    input();
  }

  private static void input() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringBuilder answer = new StringBuilder();

    while(T-- > 0){
      String[] values = br.readLine().split(" ");
      int n = Integer.parseInt(values[0]);

      double sum = 0.0;
      scores = new int[n+1];
      for(int i=1 ; i<=n; i++){
        scores[i] = Integer.parseInt(values[i]);
        sum += scores[i];
      }

      double avg = sum / n;
      double cnt = 0.0;
      for(int i=1 ; i<=n ; i++){
        if(avg < scores[i])cnt++;
      }
      answer.append(String.format("%.3f", (cnt / n ) * 100));
      answer.append("%\n");
    }
    System.out.println(answer);
    br.close();
  }
}