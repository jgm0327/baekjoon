import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] tri = new int[n+1][];

        for(int i=0 ; i<n ; i++){
            String[] str = br.readLine().split(" ");
            tri[i] = new int[str.length];
            for(int j=0 ; j<str.length ; j++){
                tri[i][j] = Integer.parseInt(str[j]);
            }
        }

        int[][] dp = new int[n + 1][n + 1];
        for(int i=0 ; i<n ; i++){
            dp[n - 1][i] = tri[n - 1][i];
        }

        for(int i=n - 2 ; i>=0 ; i--){
            for(int j=0 ; j<tri[i].length ; j++){
                dp[i][j] = tri[i][j] + Math.max(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        System.out.println(dp[0][0]);
        br.close();
    }
}