import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[] dy = { 0, 0, 1, -1 }, dx = { 1, -1, 0, 0 };
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        Integer.parseInt(tokenizer.nextToken());

        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        int score = 0, max = 0, maxRainbow = 0;
        int[] start = new int[2];
        while (true) {
            boolean[][] visit = new boolean[n][n];

            start[0] = start[1] = -1;
            max = maxRainbow = 0;
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] <= 0 || visit[i][j])
                        continue;

                    int[] size = getMaxAreaSize(i, j, visit);
                    int cnt = size[0], rainbow = size[1];
                    if (cnt + rainbow > max) {
                        max = cnt + rainbow;
                        maxRainbow = rainbow;
                        start[0] = i;
                        start[1] = j;
                    }
                    else if(cnt + rainbow == max && maxRainbow <= rainbow){
                        maxRainbow = rainbow;
                        start[0] = i;
                        start[1] = j;
                    }
                }
            }

            if (max < 2)
                break;

            score += max * max;
            disappear(start[0], start[1]);
            executeGravity();
            rotation();
            executeGravity();
        }

        System.out.println(score);

        br.close();
    }

    static void rotation() {
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                temp[n - 1 - j][i] = board[i][j];
        }
        board = temp;
    }

    static void executeGravity() {
        for (int j = 0; j < n; j++) {
            for (int i = n - 2; i >= 0; i--) {
                if (board[i][j] < 0)
                    continue;

                int start = i;
                while (start < n - 1 && board[start + 1][j] == -2) {
                    int temp = board[start][j];
                    board[start][j] = board[start + 1][j];
                    board[start + 1][j] = temp;
                    start++;
                }
            }
        }
    }

    static void disappear(int startY, int startX) {
        Queue<int[]> que = new ArrayDeque<>();
        boolean[][] visit = new boolean[n][n];

        que.add(new int[] { startY, startX });
        int color = board[startY][startX];
        board[startY][startX] = -2;
        visit[startY][startX] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            int y = cur[0], x = cur[1];
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i], nx = x + dx[i];

                if (0 > ny || ny >= n || 0 > nx || nx >= n
                        || visit[ny][nx] || board[ny][nx] == -1
                        || (board[ny][nx] != 0 && board[ny][nx] != color))
                    continue;

                board[ny][nx] = -2;
                que.add(new int[] { ny, nx });
                visit[ny][nx] = true;
            }
        }
    }

    static int[] getMaxAreaSize(int startY, int startX, boolean[][] block) {
        int cnt = 1, rainbow = 0;
        boolean[][] zero = new boolean[n][n];
        Queue<int[]> que = new ArrayDeque<>();

        que.add(new int[] { startY, startX });
        block[startY][startX] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            int y = cur[0], x = cur[1];
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i], nx = x + dx[i];

                if (0 > ny || ny >= n || 0 > nx || nx >= n
                        || block[ny][nx] || zero[ny][nx] || board[ny][nx] == -1
                        || (board[ny][nx] != 0 && board[ny][nx] != board[startY][startX]))
                    continue;

                if (board[ny][nx] > 0)
                    cnt++;
                else if(board[ny][nx] == 0)
                    rainbow++;

                if (board[ny][nx] > 0)
                    block[ny][nx] = true;
                else if(board[ny][nx] == 0)
                    zero[ny][nx] = true;

                que.add(new int[] { ny, nx });
            }
        }

        return new int[]{cnt, rainbow};
    }
}