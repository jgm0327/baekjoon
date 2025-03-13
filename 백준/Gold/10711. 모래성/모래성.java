import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 }, dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
    static int[][] destroyedCastle;
    static char[][] board;
    static Queue<int[]> que;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);

        board = new char[n][m];
        que = new ArrayDeque<>();
        destroyedCastle = new int[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                destroyedCastle[i][j] = Integer.MAX_VALUE;
                board[i][j] = input.charAt(j);

                if (board[i][j] == '.') {
                    destroyedCastle[i][j] = 0;
                }
            }
        }

        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(board[i][j] == '.' || !destroyCastle(i, j, 0))
                    continue;
                que.add(new int[]{i, j});
                destroyedCastle[i][j] = 1;
                board[i][j] = '.';
            }
        }

        int time = 1;
        while (true) {
            int size = que.size();

            while (size-- > 0) {
                int[] cur = que.poll();

                int y = cur[0], x = cur[1];
                for (int i = 0; i < 8; i++) {
                    int ny = y + dy[i], nx = x + dx[i];

                    if (0 > ny || ny >= n || 0 > nx || nx >= m
                            || board[ny][nx] == '.' || !destroyCastle(ny, nx, time))
                        continue;

                    que.add(new int[] { ny, nx });
                    board[ny][nx] = '.';
                    destroyedCastle[ny][nx] = time + 1;
                }
            }

            if(que.isEmpty())
                break;

            time++;
        }

        System.out.println(time);

        br.close();
    }

    static boolean destroyCastle(int y, int x, int time) {
        int cnt = 0;

        for (int i = 0; i < dy.length; i++) {
            int ny = y + dy[i], nx = x + dx[i];

            if (destroyedCastle[ny][nx] > time)
                continue;

            cnt++;
        }

        return cnt >= board[y][x] - '0';
    }
}