import java.io.*;
import java.util.*;

class Main {
    private static char[][] board;
    private static Queue<int[]>[] pos;
    private static int[] dist, count;
    private static int n, m, p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        p = Integer.parseInt(tokenizer.nextToken());

        dist = new int[p + 1];

        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 1; i <= p; i++) {
            dist[i] = Math.min(1000_000, Integer.parseInt(tokenizer.nextToken()));
        }

        board = new char[n][m];
        pos = new ArrayDeque[p + 1];

        for (int i = 0; i <= p; i++) {
            pos[i] = new ArrayDeque<>();
        }

        count = new int[p + 1];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (board[i][j] == '.' || board[i][j] == '#')
                    continue;

                pos[board[i][j] - '0'].add(new int[] { i, j });
                count[board[i][j] - '0']++;
            }
        }

        boolean isNotOver = true;

        while (isNotOver) {
            isNotOver = false;

            for (int i = 1; i <= p; i++) {
                int ret = bfs(i);

                // System.out.println(i + " " + ret);

                if (ret != 0)
                    isNotOver = true;

                count[i] += ret;

                // for (int s = 0; s < n; s++) {
                // for (int j = 0; j < m; j++) {
                // System.out.print(board[s][j] + " ");
                // }
                // System.out.println();
                // }
                // System.out.println();
            }

        }

        // System.out.println();

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         System.out.print(board[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= p; i++) {
            answer.append(count[i]).append(" ");
        }

        bw.write(answer.toString());

        bw.flush();
        bw.close();

        br.close();
    }

    private static int bfs(int player) {
        int ret = 0, len = dist[player];

        final int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!pos[player].isEmpty() && len-- > 0) {
            int size = pos[player].size();

            for (int i = 0; i < size; i++) {
                int[] cur = pos[player].poll();

                int y = cur[0], x = cur[1];

                for (int[] d : dir) {
                    int ny = y + d[0], nx = x + d[1];

                    if (ny < 0 || ny >= n || nx < 0 || nx >= m || board[ny][nx] != '.')
                        continue;

                    pos[player].add(new int[] { ny, nx });
                    board[ny][nx] = (char)(player + '0');
                    ret++;
                }
            }
        }

        // while (size-- > 0) {
        // int[] cur = pos[player].poll();

        // int y = cur[0], x = cur[1];

        // for (int[] d1 : dir) {
        // int ny1 = y + d1[0], nx1 = x + d1[1];

        // if (ny1 < 0 || ny1 >= n || nx1 < 0 || nx1 >= m || board[ny1][nx1] != '.')
        // continue;

        // ret++;
        // pos[player].add(new int[] { ny1, nx1 });
        // board[ny1][nx1] = (char) ('0' + player);

        // for (int i = 1; i < dist[player]; i++) {
        // for (int[] d : dir) {
        // int ny = ny1 + d[0], nx = nx1 + d[1];
        // if (ny < 0 || ny >= n || nx < 0 || nx >= m || board[ny][nx] != '.')
        // continue;

        // pos[player].add(new int[] { ny, nx });
        // board[ny][nx] = (char) ('0' + player);
        // ret++;

        // ny1 = ny;
        // nx1 = nx;
        // }
        // }
        // }

        // for(int[] d : dir){
        // for(int i=1 ; i<=dist[player] ; i++){
        // int ny = y + d[0] * i, nx = x + d[1] * i;

        // if(ny < 0 || ny >= n || nx < 0 || nx >= m || board[ny][nx] != '.')
        // break;

        // // System.out.println(p + " " + ny + " " + nx);
        // board[ny][nx] = (char)('0' + player);
        // pos[player].add(new int[]{ny, nx});

        // ret++;
        // }
        // }
        // }

        return ret;
    }
}