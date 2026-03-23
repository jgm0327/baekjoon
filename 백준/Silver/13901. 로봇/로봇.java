import java.io.*;
import java.util.*;

class Main {
    static int n, m, cnt;
    static int[] dy = {0, -1, 1, 0, 0}, dx = {0, 0, 0, -1, 1}, robot;
    static int[][] board;
    static boolean[][] visit;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());

        board = new int[n][m];
        
        int k = Integer.parseInt(br.readLine());
        while (k-- > 0) {
            tokenizer = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(tokenizer.nextToken());
            int x = Integer.parseInt(tokenizer.nextToken());

            board[y][x] = -1;
        }

        robot = new int[2];
        tokenizer = new StringTokenizer(br.readLine());
        for(int i=0 ;i<2 ; i++){
            robot[i] = Integer.parseInt(tokenizer.nextToken());
        }

        tokenizer = new StringTokenizer(br.readLine());
        visit = new boolean[n][m];
        cnt = 1;
        int[] dirs = new int[4];
        for(int i=0 ; i<4 ; i++){
            dirs[i] = Integer.parseInt(tokenizer.nextToken());
        }

        while(true){
            boolean flag = true;
            for(int i=0 ; i<4 ; i++){
                if(move(dirs[i]))
                    flag = false;
            }

            if(flag)
                break;
        }


        System.out.print(robot[0] + " " + robot[1]);

        br.close();
    }

    static boolean isIn(int y, int x){
        return 0 <= y && y < n && 0 <= x && x < m;
    }

    static boolean move(int dir){
        int y = robot[0], x = robot[1];
        board[y][x] = cnt++;
        visit[y][x] = true;

        boolean flag = false;
        while(true){
            y += dy[dir];
            x += dx[dir];
            if(!isIn(y, x) || visit[y][x] || board[y][x] == -1){
                return flag;
            }

            flag = true;
            board[y][x] = cnt++;
            robot[0] = y;
            robot[1] = x;
            visit[y][x] = true;
        }
    }
}