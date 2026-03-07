import java.util.*;
import java.io.*;

class Main {
    static int n;
    static char[][] board;
    static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 }, dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
    static int[] arr;
    static int[][] altitude;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new char[n][n];
        altitude = new int[n][n];
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

        int max = 0, idx = 0;
        arr = new int[n * n];
        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                altitude[i][j] = Integer.parseInt(tokenizer.nextToken());

                if (board[i][j] == 'P' || board[i][j] == 'K')
                    max = Math.max(max, altitude[i][j]);

                arr[idx++] = altitude[i][j];
            }
        }

        Arrays.sort(arr);

        int answer = Integer.MAX_VALUE;
        int left = 0, right = bisectLeft(max, start);
        while (left <= right && right < idx) {
            if (bfs(start, total, arr[left], arr[right])) {
                answer = Math.min(answer, arr[right] - arr[left]);
                left++;
            } else
                right++;
        }

        System.out.println(answer);

        br.close();
    }

    static int bisectLeft(int target, int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= target)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return left;
    }

    static boolean bfs(int[] start, int total, int min, int max) {
        if(min > altitude[start[0]][start[1]] || max < altitude[start[0]][start[1]])
            return false;

        Queue<int[]> que = new ArrayDeque<>();
        boolean[][] visit = new boolean[n][n];

        que.add(new int[] { start[0], start[1] });
        visit[start[0]][start[1]] = true;

        int cnt = 0;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            int y = cur[0], x = cur[1];
            for (int i = 0; i < 8; i++) {
                int ny = y + dy[i], nx = x + dx[i];
                if (0 > ny || ny >= n || 0 > nx || nx >= n || visit[ny][nx]
                        || min > altitude[ny][nx] || max < altitude[ny][nx])
                    continue;

                if (board[ny][nx] == 'K')
                    cnt++;

                if (cnt == total)
                    return true;

                visit[ny][nx] = true;
                que.add(new int[] { ny, nx });
            }
        }

        return false;
    }
}