import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
    private static int n, m;
    private static int[][] map, answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        
        map = new int[n][m];
        answer = new int[n][m];

        int[] start = new int[2];

        for(int i=0 ; i<n ; i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0 ; j<m ; j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
                if(map[i][j] == 2)start = new int[]{i, j};
            }
        }

        bfs(start);
        answer[start[0]][start[1]] = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(answer[i][j] == 0 && map[i][j] == 1) sb.append("-1 ");
                else sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static void bfs(int[] start){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{start[0], start[1], 0});
        final int[] dy = {0,0,1,-1}, dx = {1,-1,0,0};
        boolean[][] visit = new boolean[n][m];
        while(!que.isEmpty()){
            int[] cur = que.poll();
            int y = cur[0], x = cur[1], cnt = cur[2];
            for(int i=0 ; i<4 ; i++){
                int ny = y + dy[i], nx = x + dx[i];
                if(ny < 0 || ny >= n || nx < 0 || nx >= m || visit[ny][nx] || map[ny][nx] == 0)continue;
                answer[ny][nx] = cnt + 1;
                que.add(new int[]{ny, nx, cnt + 1});
                visit[ny][nx] = true;
            }   
        }
    }
}