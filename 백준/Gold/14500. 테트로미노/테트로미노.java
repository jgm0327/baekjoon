import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int n, m, answer;
    static int[] dy = { 0, 0, 1, -1 }, dx = { 1, -1, 0, 0 };
    static int[][] board;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());

        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit[i][j] = true;
                dfs(i, j, board[i][j], 0);
                visit[i][j] = false;
            }
        }

        System.out.println(answer);

        br.close();
    }

    static void dfs(int y, int x, int total, int depth) {
        if (depth == 3) {
            answer = Math.max(total, answer);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i], nx = x + dx[i];

            if (0 > ny || ny >= n || 0 > nx || nx >= m || visit[ny][nx])
                continue;

            visit[ny][nx] = true;

            if (depth == 1) {
                visit[ny][nx] = true;
                dfs(y, x, total + board[ny][nx], depth + 1);
                visit[ny][nx] = false;
            }

            visit[ny][nx] = true;
            dfs(ny, nx, total + board[ny][nx], depth + 1);
            visit[ny][nx] = false;

        }
    }
}