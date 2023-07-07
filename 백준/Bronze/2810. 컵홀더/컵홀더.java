import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine()), cnt = 0;
    String str = br.readLine();
    StringBuilder sb = new StringBuilder();

    for(int i=0 ; i<n ; i++){
      if(str.charAt(i) == 'S'){
        sb.append("*S");
      }else {
        cnt++;
        if(cnt == 2){
          sb.append("*LL");
          cnt=0;
        }
      }
    }
    sb.append("*");
    int answer = sb.length() - n;
    System.out.println(answer > n ? n : answer);
    br.close();
  }
}