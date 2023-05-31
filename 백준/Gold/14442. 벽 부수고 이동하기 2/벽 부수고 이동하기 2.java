import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
    private static class Point {
        int y, x, cnt, broken;

        public Point(int y, int x, int cnt, int broken) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
            this.broken = broken;
        }
    }

    private static int n, m, k;
    private static char[][] graph;
    private static boolean[][][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        n = Integer.parseInt(size[0]);
        m = Integer.parseInt(size[1]);
        k = Integer.parseInt(size[2]);

        visit = new boolean[n][m][k + 1];

        graph = new char[n][m];
        for (int i = 0; i < n; i++) {
            String values = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = values.charAt(j);
            }
        }
        System.out.println(bfs());
        br.close();
    }

    private static boolean isIn(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < m;
    }


    private static int bfs() {
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(0, 0, 1, 0));
        final int[] dy = {1, 0, -1, 0}, dx = {0, 1, 0, -1};

        while (!que.isEmpty()) {
            Point cur = que.poll();
            int nextCnt = cur.cnt + 1;
            if (cur.y == n - 1 && cur.x == m - 1) return cur.cnt;

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i], nx = cur.x + dx[i];
                if (ny == n - 1 && nx == m - 1) return nextCnt;
                if (!isIn(ny, nx)) continue;
                if (graph[ny][nx] == '1' && cur.broken < k && !visit[ny][nx][cur.broken + 1]) {
                    que.add(new Point(ny, nx, nextCnt, cur.broken + 1));
                    visit[ny][nx][cur.broken + 1] = true;
                } else if (graph[ny][nx] == '0' && !visit[ny][nx][cur.broken]) {
                    que.add(new Point(ny, nx, nextCnt, cur.broken));
                    visit[ny][nx][cur.broken] = true;
                }
            }
        }

        return -1;
    }
}