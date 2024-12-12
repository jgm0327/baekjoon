import java.io.*;
import java.util.*;

class Main {
    private static boolean[][] visit;
    private static int[][] board, temp;
    private static List<Integer> count;
    private static final int[] dy = {0,0,1,-1}, dx = {1,-1,0,0};
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());

        board = new int[n][m];
        List<int[]> zeros = new ArrayList<>();
        for(int i=0 ; i<n ; i++){
            tokenizer = new StringTokenizer(br.readLine());

            for(int j=0 ; j<m ; j++){
                board[i][j] = Integer.parseInt(tokenizer.nextToken());

                if(board[i][j] == 0)
                    zeros.add(new int[]{i, j});
            }
        }
        
        visit = new boolean[n][m];
        count = new ArrayList<>();
        count.add(0);

        temp = new int[n][m];
        int number = 1;
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(board[i][j] == 0 || visit[i][j])
                    continue;

                numbering(i, j, number);
                number++;
            }
        }

        int answer = 0;
        for(int[] zero : zeros){
            int y = zero[0], x = zero[1];

            int total = 1;
            Map<Integer, Boolean> already = new HashMap<>();
            for(int i=0 ; i<4 ; i++){
                int ny = y + dy[i], nx = x + dx[i];

                if(!isIn(ny, nx) || already.containsKey(temp[ny][nx]) || board[ny][nx] == 0)
                    continue;

                already.put(temp[ny][nx], true);
                total += count.get(temp[ny][nx]);
            }

            answer = Math.max(answer, total);
        }

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }

    private static void numbering(int startY, int startX, int number){
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{startY, startX});

        visit[startY][startX] = true;

        int cnt = 0;

        while(!que.isEmpty()) {
            int[] cur = que.poll();

            int y = cur[0], x = cur[1];
            temp[y][x] = number;
            cnt++;

            for(int i=0 ; i<4 ; i++){
                int ny = y + dy[i], nx = x + dx[i];

                if(!isIn(ny, nx) || visit[ny][nx] || board[ny][nx] == 0)
                    continue;

                visit[ny][nx] = true;
                que.add(new int[]{ny, nx});
            }
        }

        count.add(cnt);
    }

    private static boolean isIn(int y, int x){
        return 0 <= y && y < n && 0 <= x && x < m;
    }
}