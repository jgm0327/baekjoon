import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main{

  private static int n, k;
  private static double[] score;
  public static void main(String[] args) throws IOException{
    init();
    System.out.printf("%.2f\n", trimmedMean());
    System.out.printf("%.2f", adjustedMean());
  }

  private static void init() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] size = br.readLine().split(" ");
    n = Integer.parseInt(size[0]);
    k = Integer.parseInt(size[1]);
    score = new double[n];

    for(int i=0 ; i<n;  i++){
      score[i] = Double.parseDouble(br.readLine());
    }
    Arrays.sort(score);
    br.close();
  }

  private static double trimmedMean(){
    double ret = 0.0;
    for(int i = k; i < n - k; i++){
      ret += score[i];
    }
    ret /= (n - 2 * k);
    return ret;
  }

  private static double adjustedMean(){

    for(int i=0 ; i<k ; i++){
      score[i] = score[k];
      score[n - i - 1] = score[n - k - 1];
    }

    double ret = 0.0;
    for(int i=0 ; i<n ; i++){
      ret += score[i];
    }
    ret /= n;
    return ret;
  }
}