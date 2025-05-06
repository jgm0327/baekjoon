import java.util.*;
import java.io.*;

class Main {
    static int n, m;
    static int[] dy = { 0, 0, 1, -1 }, dx = { 1, -1, 0, 0 }, numbers, count;
    static int[][] board;
    static boolean[][] visit;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());

        board = new int[n][m];
        List<int[]> zeros = new ArrayList<>();
        List<int[]> ones = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(tokenizer.nextToken());

                if (board[i][j] == 1)
                    ones.add(new int[] { i, j });
                else
                    zeros.add(new int[] { i, j });
            }
        }

        int number = 2;
        count = new int[n * m + 3];
        visit = new boolean[n][m];
        for (int[] pos : ones) {
            int y = pos[0], x = pos[1];

            if (visit[y][x])
                continue;

            bfs(y, x, number++);
        }

        int maxValue = 0;
        for(int[] pos : zeros){
            int y = pos[0], x = pos[1];
            Map<Integer, Boolean> exist = new HashMap<>();
            int total = 0;

            for(int i=0 ; i<4 ; i++){
                int ny = y + dy[i], nx = x + dx[i];

                if(!isIn(ny, nx) || exist.containsKey(board[ny][nx]) || board[ny][nx] == 0)
                    continue;

                exist.put(board[ny][nx], true);
                total += count[board[ny][nx]];
            }

            maxValue = Math.max(maxValue, total);
        }

        System.out.println(maxValue + 1);

        br.close();
    }

    static boolean isIn(int y, int x){
        return 0 <= y && y < n && 0 <= x && x < m;
    }

    static void bfs(int startY, int startX, int number) {
        visit[startY][startX] = true;

        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[] { startY, startX });

        int ret = 0;
        while (!que.isEmpty()) {
            int[] cur = que.poll();

            int y = cur[0], x = cur[1];
            board[y][x] = number;
            ret++;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i], nx = x + dx[i];

                if (!isIn(ny, nx) || visit[ny][nx] || board[ny][nx] == 0)
                    continue;

                visit[ny][nx] = true;
                que.add(new int[] { ny, nx });
            }
        }

        count[number] = ret;
    }
}