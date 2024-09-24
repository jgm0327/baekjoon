import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] board = new int[n + 1][n + 1];
        int[][] prefix = new int[n + 1][n + 1];
        for(int i=1 ; i<=n ; i++){
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            for(int j=1 ; j<=n ; j++){
                board[i][j] = Integer.parseInt(tokenizer.nextToken());
                prefix[i][j] = board[i][j] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
            }
        }

        int answer = Integer.MIN_VALUE;
        for(int size = 1 ; size <= n ; size++){
            for(int y=1 ; y<=n-size+1 ; y++){
                for(int x=1 ; x<=n-size+1 ; x++){
                    int total = prefix[y+size-1][x+size-1] - prefix[y-1][x+size-1] - prefix[y+size-1][x-1] + prefix[y-1][x-1];
                    answer = Math.max(total, answer);
                }
            }
        }

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}