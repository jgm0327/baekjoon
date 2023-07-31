import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String document = br.readLine();
    String target = br.readLine();
    int idx = 0, answer = 0;
    while(true){
      idx = document.indexOf(target, idx);
      if(idx == -1)break;
      idx += target.length();
      answer++;
    }
    System.out.println(answer);
    br.close();
  }
}