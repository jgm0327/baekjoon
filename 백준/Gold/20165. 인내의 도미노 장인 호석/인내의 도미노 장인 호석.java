import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int[] dy = { 0, 0, 1, -1 }, dx = { 1, -1, 0, 0 };
    static int[][] board;
    static boolean[][] isFallen;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        int R = Integer.parseInt(tokenizer.nextToken());

        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        isFallen = new boolean[n][m];
        int total = 0;
        while (R-- > 0) {
            tokenizer = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(tokenizer.nextToken()) - 1;
            int c = Integer.parseInt(tokenizer.nextToken()) - 1;
            int dir = getDir(tokenizer.nextToken().charAt(0));

            total += offense(r, c, dir);

            tokenizer = new StringTokenizer(br.readLine());

            r = Integer.parseInt(tokenizer.nextToken()) - 1;
            c = Integer.parseInt(tokenizer.nextToken()) - 1;

            isFallen[r][c] = false;
        }

        StringBuilder answer = new StringBuilder();
        answer.append(total).append("\n");
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(isFallen[i][j]){
                    answer.append("F ");
                }
                else answer.append("S ");
            }
            answer.append('\n');
        }
        System.out.println(answer);

        br.close();
    }

    static int offense(int r, int c, int dir){
        if(isFallen[r][c])
            return 0;

        int ret = 0;
        int size = board[r][c] - 1;
        while(0 <= c && c < m && 0 <= r && r < n && size > 0){
            size--;
            if(!isFallen[r][c]){
                isFallen[r][c] = true;
                ret++;
                size = Math.max(size, board[r][c] - 1);
            }

            r = r + dy[dir];
            c = c + dx[dir];
        }
        return ret;
    }

    static int getDir(char dir){
        if(dir == 'E') return 0;
        if(dir == 'W')return 1;
        if(dir == 'S')return 2;
        return 3;
    }

}