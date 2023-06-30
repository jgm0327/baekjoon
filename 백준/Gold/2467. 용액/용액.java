import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
  private static int n;
  private static int[] liquids;

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    String[] values = br.readLine().split(" ");

    liquids = new int[n];
    for(int i=0 ; i<n ; i++){
      liquids[i] = Integer.parseInt(values[i]);
    }

    int start = 0, end = n - 1;
    int a1 = liquids[start], a2 = liquids[end], comp = Integer.MAX_VALUE;

    while(start < end){
      int sum = liquids[start] + liquids[end];
      if(Math.abs(sum) < comp){
        comp = Math.abs(sum);
        a1 = liquids[start];
        a2 = liquids[end];
      }if(sum < 0){
        start++;
      }else{
        end--;
      }
    }
    System.out.println(a1 + " " + a2);
    br.close();
  }
}