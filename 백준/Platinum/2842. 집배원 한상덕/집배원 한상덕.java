import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[] dy = { -1, -1, -1, 0, 1, 1, 1, 0 }, dx = { -1, 0, 1, 1, 1, 0, -1, -1 };
    static char[][] board;
    static int[][] altitude;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        board = new char[n][n];
        int[] start = new int[2];
        int total = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            for (int j = 0; j < n; j++) {
                board[i][j] = str.charAt(j);

                if (board[i][j] == 'P')
                    start = new int[] { i, j };
                else if (board[i][j] == 'K')
                    total++;
            }
        }

        altitude = new int[n][n];
        int[] arr = new int[n * n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                altitude[i][j] = Integer.parseInt(tokenizer.nextToken());
                arr[idx++] = altitude[i][j];
            }
        }

        Arrays.sort(arr);
        int left = 0, right = 0, answer = Integer.MAX_VALUE;
        while (left <= right && right < idx) {
            if(bfs(start[0], start[1], total, arr[left], arr[right])){
                answer = Math.min(answer, arr[right] - arr[left]);
                left++;
            }
            else
                right++;
        }
        System.out.println(answer);

        br.close();
    }

    static boolean bfs(int startY, int startX, int total, int min, int max) {
        if(altitude[startY][startX] > max || altitude[startY][startX] < min)
            return false;

        int cnt = 0;

        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[] { startY, startX });

        boolean[][] visit = new boolean[n][n];
        visit[startY][startX] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            int y = cur[0], x = cur[1];

            for (int i = 0; i < 8; i++) {
                int ny = y + dy[i], nx = x + dx[i];

                if(0 > ny || ny >= n || 0 > nx || nx >= n 
                    || visit[ny][nx] 
                    || altitude[ny][nx] < min || altitude[ny][nx] > max)
                    continue;

                if(board[ny][nx] == 'K')
                    cnt++;

                if(total == cnt)
                    return true;

                visit[ny][nx] = true;
                que.add(new int[]{ny, nx});
            }
        }

        return false;
    }
}