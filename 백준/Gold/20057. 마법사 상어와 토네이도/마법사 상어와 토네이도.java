import java.io.*;
import java.util.*;

class Main {

    private static int n, leftX, rightX, downY, upY, answer, cnt;
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
            int[] pos = moveTornado(y, x, 0, -1, y, leftX, 0);
            y = pos[0];
            x = pos[1];

            if(y == 0 && x == 0){
                break;
            }
            leftX--;

            // 아래쪽 이동
            pos = moveTornado(y, x, 1, 0, downY, x, 1);

            y = pos[0];
            x = pos[1];
            downY++;

            // 오른쪽 이동
            pos = moveTornado(y, x, 0, 1, y, rightX, 2);
            y = pos[0];
            x = pos[1];
            rightX++;

            // 위쪽 이동
            pos = moveTornado(y, x, -1, 0, upY, x, 3);
            y = pos[0];
            x = pos[1];
            upY--;
        }

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }

    private static boolean isIn(int y, int x){
        return 0 <= y && y < n && 0 <= x && x < n;
    }

    private static int[] moveTornado(int y, int x, int dy, int dx, int targetY, int targetX, int idx){
        while((y != targetY || x != targetX) && isIn(y + dy, x + dx)){

            int total = board[y + dy][x + dx] - spreadSand(idx, y + dy, x + dx);

            if(isIn(y + dy * 2, x + dx * 2))
                board[y + dy * 2][x + dx * 2] += total;
            else 
                answer += total;

            board[y + dy][x + dx] = 0;
            
            y += dy;
            x += dx;
        }

        return new int[]{y, x};
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