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
        Arrays.fill(arr, Integer.MAX_VALUE);
        int idx = 0, max = 0;
        Map<Integer, Boolean> exist = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                altitude[i][j] = Integer.parseInt(tokenizer.nextToken());
                if(exist.containsKey(altitude[i][j]))
                    continue;

                if(board[i][j] == 'K' || board[i][j] == 'P')
                    max = Math.max(max, altitude[i][j]);

                exist.put(altitude[i][j], true);
                arr[idx++] = altitude[i][j];
            }
        }

        Arrays.sort(arr);
        int left = 0, right = bisectLeft(max, arr), answer = Integer.MAX_VALUE;
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

    static int bisectLeft(int target, int[] arr){
        int left = 0, right = arr.length - 1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(target <= arr[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }

        return left;
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