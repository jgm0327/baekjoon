import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int[] dy = { 0, 0, 1, -1 }, dx = { 1, -1, 0, 0 };
    static int[] count;
    static int[][] numbering;
    static char[][] board;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);

        board = new char[n][m];
        List<int[]> zeroPos = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                board[i][j] = input[j];
                if(board[i][j] == '0')
                    zeroPos.add(new int[] { i, j });
            }
        }

        boolean[][] visit = new boolean[n][m];
        count = new int[zeroPos.size() + 1];

        int number = 1;
        numbering = new int[n][m];
        for(int[] pos : zeroPos){
            if(visit[pos[0]][pos[1]])
                continue;

            bfs(pos[0], pos[1], number++, visit);
        }

        StringBuilder answer = new StringBuilder();
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(board[i][j] == '0')
                    answer.append("0");
                else
                    answer.append((1 + aroundSum(i, j, number + 1)) % 10);
            }
            answer.append("\n");
        }

        System.out.print(answer);
        br.close();
    }

    static int aroundSum(int y, int x, int size){
        int total = 0;

        boolean[] visit = new boolean[size];
        for(int i=0 ; i<4 ; i++){
            int ny = y + dy[i], nx = x + dx[i];

            if(!isIn(ny, nx) || board[ny][nx] == '1' || visit[numbering[ny][nx]])
                continue;

            total += count[numbering[ny][nx]];
            visit[numbering[ny][nx]] = true;
        }

        return total;
    }

    static boolean isIn(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < m;
    }

    static void bfs(int startY, int startX, int number, boolean[][] visit) {
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[] { startY, startX });

        visit[startY][startX] = true;

        int ret = 0;
        while(!que.isEmpty()){
            int[] cur = que.poll();

            int y = cur[0], x = cur[1];
            numbering[y][x] = number;
            ret++;

            for(int i=0 ; i<4 ; i++){
                int ny = y + dy[i], nx = x + dx[i];

                if(!isIn(ny, nx) || board[ny][nx] == '1' || visit[ny][nx])
                    continue;

                visit[ny][nx] = true;
                que.add(new int[]{ny, nx});
            }
        }

        count[number] = ret;
    }
}