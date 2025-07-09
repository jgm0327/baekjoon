import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

class Main {
    static int n, m, sheepCount, wolfCount;
    static int[] dy = { 0, 0, 1, -1 }, dx = { 1, -1, 0, 0 };
    static char[][] board;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");
        n = Integer.parseInt(arr[0]);
        m = Integer.parseInt(arr[1]);

        board = new char[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            for (int j = 0; j < m; j++) {
                board[i][j] = input.charAt(j);

                if (board[i][j] == 'v')
                    wolfCount++;
                else if (board[i][j] == 'o')
                    sheepCount++;
            }
        }

        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visit[i][j] || board[i][j] == '#')
                    continue;

                bfs(i, j);
            }
        }

        System.out.println(sheepCount + " " + wolfCount);
        br.close();
    }

    static void bfs(int startY, int startX) {
        int vCount = board[startY][startX] == 'v' ? 1 : 0, oCount = board[startY][startX] == 'o' ? 1 : 0;
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[] { startY, startX });

        visit[startY][startX] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            int y = cur[0], x = cur[1];
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i], nx = x + dx[i];

                if (0 > ny || ny >= n || 0 > nx
                        || nx >= m || visit[ny][nx] || board[ny][nx] == '#')
                    continue;

                if (board[ny][nx] == 'v')
                    vCount++;
                else if (board[ny][nx] == 'o')
                    oCount++;

                visit[ny][nx] = true;
                que.add(new int[] { ny, nx });
            }
        }

        if (vCount < oCount)
            wolfCount -= vCount;
        else
            sheepCount -= oCount;

    }
}