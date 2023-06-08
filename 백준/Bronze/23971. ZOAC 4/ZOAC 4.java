import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] size = br.readLine().split(" ");
    int h, w, n, m;
    h = Integer.parseInt(size[0]);
    w = Integer.parseInt(size[1]);
    n = Integer.parseInt(size[2]);
    m = Integer.parseInt(size[3]);
    int nh = h % (n + 1) == 0 ? h / (n + 1) : (h / (n + 1)) + 1;
    int nw = w % (m + 1) == 0 ? w / (m + 1) : (w / (m + 1)) + 1;
    System.out.println(nh * nw);
    br.close();
  }
}