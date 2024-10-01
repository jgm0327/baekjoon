import java.io.*;
import java.util.*;

class Main {

    private static int[][] board;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        for(int i=0 ; i<n ; i++){
            String input = br.readLine();

            for(int j=0 ; j<n ; j++){
                board[i][j] = input.charAt(j) - '0';
            }
        }

        bw.write(String.valueOf(bfs()));
        bw.close();
        br.close();
    }

    private static int bfs(){
        int ret = Integer.MAX_VALUE;

        boolean[][][] visit = new boolean[n][n][n*n];
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{0,0,0});
        
        for(int i=0 ; i<n*n ; i++){
            visit[0][0][i] = true;
        }

        int[] dy = {0,0,1,-1}, dx = {1,-1,0,0};

        while(!que.isEmpty()){
            int[] cur = que.poll();

            int y = cur[0], x = cur[1], count = cur[2];

            for(int i=0 ; i<4 ; i++){
                int ny = y + dy[i], nx = x + dx[i], nextCount = count;

                if(0 > ny || ny >= n || 0 > nx || nx >= n)
                    continue;

                if(ny == n - 1 && nx == n - 1){
                    ret = Math.min(ret, count);
                    continue;
                }

                if(board[ny][nx] == 0)
                    nextCount++;
                    
                if(nextCount >= n * n)
                    continue;

                if(visit[ny][nx][nextCount])
                    continue;


                que.add(new int[]{ny, nx, nextCount});
                visit[ny][nx][nextCount] = true;
            }
        }

        return ret;
    }
}