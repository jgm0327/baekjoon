import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static char[][] board;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);

        int[] start = new int[2];
        board = new char[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j);

                if (board[i][j] == '0')
                    start = new int[] { i, j };
            }
        }

        System.out.println(bfs(start[0], start[1]));

        br.close();
    }

    static int bfs(int startY, int startX) {
        Queue<int[]> que = new ArrayDeque<>();
        // y, x, dist, containsKey
        que.add(new int[] { startY, startX, 0, 0 });
        int size = (1 << 7) - 1;

        boolean[][][] visit = new boolean[n][m][size];
        visit[startY][startX][0] = true;

        int[] dy = { 0, 0, 1, -1 }, dx = { 1, -1, 0, 0 };

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            int y = cur[0], x = cur[1], dist = cur[2], keys = cur[3];
            for(int i=0 ; i<4 ; i++){
                int ny = y + dy[i], nx = x + dx[i];
                
                if(0 > ny || ny >= n || 0 > nx || nx >= m || board[ny][nx] == '#' || visit[ny][nx][keys])
                    continue;

                if(board[ny][nx] == '1')
                    return dist + 1;

                int nextKey = keys;
                if('a' <= board[ny][nx] && board[ny][nx] <= 'f')
                    nextKey |= (1 << (board[ny][nx] - 'a'));
                else if(('A' <= board[ny][nx] && board[ny][nx] <= 'F') && (nextKey & (1 << (board[ny][nx] - 'A'))) == 0)
                    continue;

                visit[ny][nx][nextKey] = true;
                que.add(new int[]{ny, nx, dist + 1, nextKey});
            }
        }

        return -1;
    }
}