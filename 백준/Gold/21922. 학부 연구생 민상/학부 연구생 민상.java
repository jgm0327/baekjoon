import java.io.*;
import java.util.*;

class Main {
    
    private static int n, m;
    private static final int[][] curveDir = {{0, 1, 2, 3}, {1, 0, 2, 3}, {0, 1, 3, 2}, {3, 2, 1, 0}, {2, 3, 0, 1}};
    private static final int[] dy = {0, 0, -1, 1}, dx = {-1, 1, 0, 0};
    private static int[][] laboratory;
    private static boolean[][][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());

        laboratory = new int[n][m];
        visit = new boolean[n][m][4];
        List<int[]> airControllerPos = new ArrayList<>();
        for(int i=0 ; i<n ; i++){
            tokenizer = new StringTokenizer(br.readLine());

            for(int j=0 ; j<m ; j++){
                laboratory[i][j] = Integer.parseInt(tokenizer.nextToken());

                if(laboratory[i][j] == 9){
                    Arrays.fill(visit[i][j], true);
                    airControllerPos.add(new int[]{i, j});
                }
            }
        }

        boolean[][] available = new boolean[n][m];
        for(int[] start : airControllerPos){
            available[start[0]][start[1]] = true;
            bfs(start, available);
        }

        int answer = 0;
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m; j++){
                if(!available[i][j])
                    continue;

                answer++;
            }
        }

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }

    private static void bfs(int[] start, boolean[][] available){
        available[start[0]][start[1]] = true;
        Queue<int[]> que = new ArrayDeque<>();
        
        for(int i=0 ; i<4 ; i++){
            addQueue(start[0], start[1], i, que, available);
        }

        while(!que.isEmpty()){
            int[] cur = que.poll();

            int y = cur[0], x = cur[1], dir = cur[2];
            addQueue(y, x, dir, que, available);
        }
    }

    private static void addQueue(int y, int x, int dir, Queue<int[]> que, boolean[][] available){
        int ny = y + dy[dir], nx = x + dx[dir];
        if(!isIn(ny, nx) || visit[ny][nx][dir])
            return;

        visit[ny][nx][dir] = true;
        available[ny][nx] = true;
        if(laboratory[ny][nx] == 0){
            que.add(new int[]{ny, nx, dir});
            return;
        }

        int curveY = ny, curveX = nx;
        int nextDir = curveDir[laboratory[ny][nx]][dir];

        boolean cantAdd = false;
        while(laboratory[curveY][curveX] != 0){
            curveY = curveY + dy[nextDir];
            curveX = curveX + dx[nextDir];

            if(!isIn(curveY, curveX) || visit[curveY][curveX][nextDir]){
                cantAdd = true;
                break;
            }

            available[curveY][curveX] = true;
            visit[curveY][curveX][nextDir] = true;
            nextDir = curveDir[laboratory[curveY][curveX]][nextDir];
        }

        if(cantAdd)
            return;
            
        que.add(new int[]{curveY, curveX, nextDir});
    }

    private static boolean isIn(int y, int x){
        return 0 <= y && y < n && 0 <= x && x < m;
    }
}