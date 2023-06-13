import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class Main{

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int T = Integer.parseInt(br.readLine());
    int n, m;

    while(T-- > 0){
      String[] size = br.readLine().split(" ");
      n = Integer.parseInt(size[0]);
      m = Integer.parseInt(size[1]);
      int[] arr1 = new int[n], arr2 = new int[m];

      String[] str = br.readLine().split(" ");
      for(int i=0 ; i<n ; i++){
        arr1[i] = Integer.parseInt(str[i]);
      }

      str = br.readLine().split(" ");
      for(int i=0 ; i<m ; i++){
        arr2[i] = Integer.parseInt(str[i]);
      }

      Arrays.sort(arr1);
      Arrays.sort(arr2);
      int ans = 0;
      for(int i=0 ; i<n ; i++){
        for(int j=0 ; j<m ; j++){
          if(arr1[i] <= arr2[j])break;
          ans++;
        }
      }
      bw.write(ans+"\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }
}