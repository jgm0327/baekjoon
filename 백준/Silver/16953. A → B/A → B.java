import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] str = br.readLine().split(" ");
    int n = Integer.parseInt(str[0]), m = Integer.parseInt(str[1]), answer=0;
    while(m > n){
      answer++;
      if(m % 10 == 1)m /= 10;
      else if (m % 2 == 0)m /= 2;
      else break;
    }
    System.out.println(m == n ? answer + 1 : -1);
    br.close();
  }
}