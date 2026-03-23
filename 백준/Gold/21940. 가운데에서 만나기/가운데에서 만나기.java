import java.io.*;
import java.util.*;

class Main {
    static List<int[]>[] graph;
    static int n;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        int[][] board = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++){
            Arrays.fill(board[i], Integer.MAX_VALUE);
            board[i][i] = 0;
        }

        while (m-- > 0) {
            tokenizer = new StringTokenizer(br.readLine());
            int sour = Integer.parseInt(tokenizer.nextToken());
            int des = Integer.parseInt(tokenizer.nextToken());
            int dist = Integer.parseInt(tokenizer.nextToken());

            board[sour][des] = dist;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (board[i][k] == Integer.MAX_VALUE || board[k][j] == Integer.MAX_VALUE)
                        continue;

                    board[i][j] = Math.min(board[i][j], board[i][k] + board[k][j]);
                }
            }
        }

        int k = Integer.parseInt(br.readLine());
        int[] arr = new int[k];

        tokenizer = new StringTokenizer(br.readLine());
        for(int i=0 ; i<k ; i++)
            arr[i] = Integer.parseInt(tokenizer.nextToken());

        int minValue = Integer.MAX_VALUE;
        StringBuilder answer = new StringBuilder();
        for(int x=1 ; x<=n ; x++){
            int max = 0;
            for(int y : arr){
                if(board[y][x] == Integer.MAX_VALUE || board[x][y] == Integer.MAX_VALUE)
                    continue;

                max = Math.max(max, board[y][x] + board[x][y]);
            }

            if(minValue > max){
                answer = new StringBuilder();
                answer.append(x).append(" ");
                minValue = max;
            }
            else if(minValue == max)
                answer.append(x).append(" ");
        }

        System.out.println(answer);

        br.close();
    }
}