import java.io.*;
import java.util.*;

class Main {

    private static int n, leftX, rightX, downY, upY, answer;
    private static int[][] board;

    private static double[][][] rateSandAmount = {
        {
            {0.00, 0.00, 0.02, 0.00, 0.00},
            {0.00, 0.10, 0.07, 0.01, 0.00},
            {0.05, 0.00, 0.00, 0.00, 0.00},
            {0.00, 0.10, 0.07, 0.01, 0.00},
            {0.00, 0.00, 0.02, 0.00, 0.00}
        },
        {
            {0.00, 0.00, 0.00, 0.00, 0.00},
            {0.00, 0.01, 0.00, 0.01, 0.00},
            {0.02, 0.07, 0.00, 0.07, 0.02},
            {0.00, 0.10, 0.00, 0.10, 0.00},
            {0.00, 0.00, 0.05, 0.00, 0.00}
        },

        {
            {0.00, 0.00, 0.02, 0.00, 0.00},
            {0.00, 0.01, 0.07, 0.10, 0.00},
            {0.00, 0.00, 0.00, 0.00, 0.05},
            {0.00, 0.01, 0.07, 0.10, 0.00},
            {0.00, 0.00, 0.02, 0.00, 0.00}
        },
        {
            {0.00, 0.00, 0.05, 0.00, 0.00},
            {0.00, 0.10, 0.00, 0.10, 0.00},
            {0.02, 0.07, 0.00, 0.07, 0.02},
            {0.00, 0.01, 0.00, 0.01, 0.00},
            {0.00, 0.00, 0.00, 0.00, 0.00}
        }
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        board = new int[n][n];

        for(int i=0 ; i<n ; i++){
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            for(int j=0 ; j<n ; j++){
                board[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        int y = n / 2, x = n / 2;
        
        leftX = x - 1;
        downY = y + 1;
        rightX = x + 1;
        upY = y - 1;

        while(true){
            // 왼쪽 이동
            while(x != leftX && x > 0){
                int temp = spreadSand(0, y, x - 1);
                if(x - 2 >= 0)board[y][x - 2] += board[y][x - 1] - temp;
                else answer += board[y][x - 1] - temp;
                board[y][x - 1] = 0;
                x--;
            }
            
            if(y == 0 && x == 0){
                break;
            }
            leftX--;

            // 아래쪽 이동
            while(y != downY && y < n - 1){
                int temp = spreadSand(1, y + 1, x);
                if(y + 2 < n)board[y + 2][x] += board[y + 1][x] - temp;
                else answer += board[y + 1][x] - temp;
                board[y + 1][x] = 0;
                y++;
            }
            downY++;

            // 오른쪽 이동
            while(x != rightX && x < n - 1){
                int temp = spreadSand(2, y, x + 1);
                if(x + 2 < n)board[y][x + 2] += board[y][x + 1] - temp;
                else answer += board[y][x + 1] - temp;
                board[y][x + 1] = 0;
                x++;
            }
            rightX++;

            // 위쪽 이동
            while(y != upY && y >= 0){
                int temp = spreadSand(3, y - 1, x);
                if(y - 2 >= 0)board[y - 2][x] += board[y - 1][x] - temp;
                else answer += board[y - 1][x] - temp;
                board[y - 1][x] = 0;
                y--;
            }
            upY--;
        }

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }

    private static boolean isIn(int y, int x){
        return 0 <= y && y < n && 0 <= x && x < n;
    }

    private static int spreadSand(int idx, int y, int x){
        int ret = 0;
        int startY = y - 2, startX = x - 2;

        for(int i=0 ; i<5 ; i++){
            for(int j=0 ; j<5 ; j++){
                int ny = startY + i, nx = startX + j;

                int amount = (int)Math.floor(rateSandAmount[idx][i][j] * board[y][x]);

                ret += amount;

                if(!isIn(ny, nx)){
                    answer += amount;
                    continue;
                }

                board[ny][nx] += amount;
            }
        }

        return ret;
    }
}