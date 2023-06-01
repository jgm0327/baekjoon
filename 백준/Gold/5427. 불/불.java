import java.io.*;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    private static int n, m;
    private static char[][] graph;
    private static Queue<int[]> fire;
    private static boolean[][] visitJ, visitF;
    private static final int[] dy = {0, 0, -1, 1}, dx = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] size = br.readLine().split(" ");
            n = Integer.parseInt(size[1]);
            m = Integer.parseInt(size[0]);

            graph = new char[n][m];
            visitJ = new boolean[n][m];
            visitF = new boolean[n][m];
            fire = new LinkedList<>();

            int[] start = new int[2];
            for (int i = 0; i < n; i++) {
                String values = br.readLine();
                for (int j = 0; j < m; j++) {
                    graph[i][j] = values.charAt(j);
                    if (graph[i][j] == '@') {
                        start = new int[]{i, j};
                        visitJ[i][j] = true;
                    } else if (graph[i][j] == '*') {
                        fire.add(new int[]{i, j});
                        visitF[i][j] = true;
                    }
                }
            }
            int answer = bfs(start);
            bw.write((answer == -1 ? "IMPOSSIBLE" : answer) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean isIn(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < m;
    }

    private static int bfs(int[] start) {
        Queue<int[]> ji = new LinkedList<>();
        ji.add(new int[]{start[0], start[1], 1});

        while (!ji.isEmpty()) {
            int size = fire.size();
            for (int i = 0; i < size; i++) {
                int[] curF = fire.poll();
                spreadFire(curF[0], curF[1]);
            }

            size = ji.size();
            for (int i = 0; i < size; i++) {
                int[] curJ = ji.poll();
                if (curJ[0] == 0 || curJ[0] == n - 1 || curJ[1] == 0 || curJ[1] == m - 1) return curJ[2];
                movePerson(curJ, ji);
            }
        }
        return -1;
    }

    private static void spreadFire(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i], nx = x + dx[i];
            if (!isIn(ny, nx)) continue;
            if (!visitF[ny][nx] && graph[ny][nx] != '#') {
                visitF[ny][nx] = true;
                graph[ny][nx] = '*';
                fire.add(new int[]{ny, nx});
            }
        }
    }

    private static void movePerson(int[] cur, Queue<int[]> ji) {
        int y = cur[0], x = cur[1], cnt = cur[2];
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i], nx = x + dx[i];
            if (!isIn(ny, nx)) continue;
            if (!visitJ[ny][nx] && graph[ny][nx] == '.') {
                visitJ[ny][nx] = true;
                ji.add(new int[]{ny, nx, cnt + 1});
            }
        }
    }
}