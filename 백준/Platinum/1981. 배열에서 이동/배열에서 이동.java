import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int[][] board;
    static int[] dy = { 0, 0, 1, -1 }, dx = { 1, -1, 0, 0 };
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        int left = 0, right = 200;
        while (left <= right) {
            int limit = (left + right) / 2;

            if (canGo(limit)) {
                right = limit - 1;
            } else {
                left = limit + 1;
            }
        }

        System.out.println(left);

        br.close();
    }

    static boolean canGo(int limit) {
        for (int i = board[0][0] - limit; i <= board[0][0]; i++) {
            if(bfs(limit, i, i + limit))
                return true;
        }
        return false;
    }

    static boolean bfs(int limit, int min, int max) {
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[] { 0, 0 });

        boolean[][] visit = new boolean[n][n];
        visit[0][0] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            int y = cur[0], x = cur[1];
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i], nx = x + dx[i];

                if (0 > ny || ny >= n || 0 > nx || nx >= n || visit[ny][nx]
                        || board[ny][nx] < min || board[ny][nx] > max)
                    continue;

                if (ny == n - 1 && nx == n - 1)
                    return true;

                visit[ny][nx] = true;
                que.add(new int[] { ny, nx });
            }
        }

        return false;
    }
}
