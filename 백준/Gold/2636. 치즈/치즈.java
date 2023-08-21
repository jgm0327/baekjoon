import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
    private static int n, m, cheeseCnt = 0;
    private static final int[] dy = {0,0,1,-1}, dx = {1,-1,0,0};
    private static int[][] board;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        n = Integer.parseInt(size[0]);
        m = Integer.parseInt(size[1]);

        board = new int[n][m];
        for(int i=0 ; i<n ; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int j=0 ; j<m ; j++){
                board[i][j] = Integer.parseInt(stk.nextToken());
                if(board[i][j] == 1)
                    cheeseCnt++;
            }
        }

        int prev = cheeseCnt, time = 0;
        while(cheeseCnt > 0){
            prev = cheeseCnt;
            time++;
            bfs();
        }
        System.out.println(time + "\n" + prev);
        br.close();
    }

    private static void bfs(){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0,0});
        boolean[][] visit = new boolean[n][m];
        visit[0][0] = true;

        while(!que.isEmpty()){
            int[] cur = que.poll();
            int y = cur[0], x = cur[1];
            for(int i=0 ; i<4 ; i++){
                int ny = y + dy[i], nx = x + dx[i];
                if(ny < 0 || ny >= n || nx < 0 || nx >= m || visit[ny][nx])
                    continue;
                visit[ny][nx] = true;
                if(board[ny][nx] == 1){
                    board[ny][nx] = 0;
                    cheeseCnt--;
                    continue;
                }
                que.add(new int[]{ny, nx});
            }
        }
    }
}