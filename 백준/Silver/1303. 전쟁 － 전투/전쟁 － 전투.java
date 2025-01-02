import java.io.*;
import java.util.*;

class Main{

    private static int n, m;
    private static char[][] board;
    private static boolean[][] visit;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");
        m = Integer.parseInt(split[0]);
        n = Integer.parseInt(split[1]);

        board = new char[n][m];
        for(int i=0 ; i<n ; i++){
            String str = br.readLine();

            for(int j=0 ; j<m ; j++){
                board[i][j] = str.charAt(j);
            }
        }

        visit = new boolean[n][m];
        int[] answer = new int[2];
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(visit[i][j])
                    continue;

                int ret = bfs(i, j, board[i][j]);
                if(board[i][j] == 'W')answer[0] += ret;
                else answer[1] += ret;
            }
        }

        bw.write(answer[0] + " " + answer[1]);
		bw.close();
		br.close();
	}

    private static int bfs(int startY, int startX, char color){
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{startY, startX});

        visit[startY][startX] = true;
        int ret = 0;

        int[] dy = {0,0,1,-1}, dx = {1, -1, 0, 0};

        while(!que.isEmpty()){
            int[] cur = que.poll();
            ret++;

            int y = cur[0], x = cur[1];
            for(int i=0 ; i<4 ; i++){
                int ny = y + dy[i], nx = x + dx[i];

                if(0 > ny || ny >= n || 0 > nx || nx >= m || color != board[ny][nx] || visit[ny][nx])
                    continue;

                que.add(new int[]{ny, nx});
                visit[ny][nx] = true;
            }
        }

        return ret * ret;
    }
}