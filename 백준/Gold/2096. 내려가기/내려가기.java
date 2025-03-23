import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][3];
        for(int i=0 ; i<n ; i++){
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int c = Integer.parseInt(tokenizer.nextToken());

            board[i] = new int[]{a, b, c};
        }

        int[][] maxDp = new int[n + 1][3];
        int[][] minDp = new int[n + 1][3];
        for(int i=0 ; i<n ; i++){
            maxDp[i + 1][0] = Math.max(maxDp[i][0], maxDp[i][1]) + board[i][0];
            maxDp[i + 1][1] = Math.max(Math.max(maxDp[i][0], maxDp[i][1]), maxDp[i][2]) + board[i][1];
            maxDp[i + 1][2] = Math.max(maxDp[i][1], maxDp[i][2]) + board[i][2];

            minDp[i + 1][0] = Math.min(minDp[i][0], minDp[i][1]) + board[i][0];
            minDp[i + 1][1] = Math.min(Math.min(minDp[i][0], minDp[i][1]), minDp[i][2]) + board[i][1];
            minDp[i + 1][2] = Math.min(minDp[i][1], minDp[i][2]) + board[i][2];
        }

        int max = 0, min = Integer.MAX_VALUE;
        for(int i=0 ; i<3 ; i++){
            max = Math.max(max, maxDp[n][i]);
            min = Math.min(min, minDp[n][i]);
        }

        System.out.println(max + " " + min);

        br.close();
    }
}