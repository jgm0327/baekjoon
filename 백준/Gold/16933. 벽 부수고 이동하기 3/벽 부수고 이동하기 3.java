import java.io.*;
import java.util.*;

class Main {
    private static int n, m, k;
    private static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        k = Integer.parseInt(tokenizer.nextToken());

        board = new char[n][m];

        for(int i=0 ; i<n ; i++){
            String input = br.readLine();
            for(int j=0 ; j<m ; j++){
                board[i][j] = input.charAt(j);
            }
        }

        bw.write(String.valueOf(bfs()));

        bw.flush();
        bw.close();
        
        br.close();
    }

    private static int bfs(){
        if(n == 1 && m == 1)return 1;

        Queue<int[]> que = new ArrayDeque<>();

        // y, x, dist, break_wall_count, day_night
        que.add(new int[]{0,0,1,0,1});

        int ret = Integer.MAX_VALUE;

        int[][][] visit = new int[n][m][k + 1];
        
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                Arrays.fill(visit[i][j], Integer.MAX_VALUE);
            }
        }

        Arrays.fill(visit[0][0], 0);

        final int[] dy = {0,0,1,-1}, dx = {-1,1,0,0};

        while(!que.isEmpty()){
            int[] cur = que.poll();

            int y = cur[0], x= cur[1], dist = cur[2], 
            breakCount = cur[3], dayOrNight = cur[4];
            
            for(int i=0 ; i<4 ; i++){
                int ny = y + dy[i], nx = x + dx[i];

                if(ny < 0 || ny >= n || nx < 0 || nx >= m)continue;

                if(board[ny][nx] == '0'){
                    if(visit[ny][nx][breakCount] <= dist + 1)continue;

                    if(ny == n - 1 && nx == m - 1){
                        ret = Math.min(ret, dist + 1);
                    }

                    visit[ny][nx][breakCount] = dist + 1;
                    que.add(new int[]{ny, nx, dist + 1, breakCount, 1 - dayOrNight});
                }
                else{
                    if(breakCount == k)continue;

                    if(dayOrNight == 0 && visit[ny][nx][breakCount + 1] > dist + 2){
                        visit[ny][nx][breakCount + 1] = dist + 2;
                        que.add(new int[]{ny, nx, dist + 2, breakCount + 1, dayOrNight});
                    }
                    else if(dayOrNight == 1 && visit[ny][nx][breakCount + 1] > dist + 1){
                        que.add(new int[]{ny, nx, dist + 1, breakCount + 1, 1 - dayOrNight});
                        visit[ny][nx][breakCount + 1] = dist + 1;
                    }
                }
            }
        }

        return ret == Integer.MAX_VALUE ? -1 : ret;
    }
}